package backend.service;

import backend.dto.HrRecordDto;
import backend.entity.HrRecord;
import backend.entity.Record;
import backend.mapper.HrRecordMapper;
import backend.repository.HrRecordRepository;
import backend.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrRecordService {
    private final RecordRepository recordRepository;
    private final HrRecordRepository repository;
    private final HrRecordMapper mapper;

    public HrRecordService(RecordRepository recordRepository, HrRecordRepository repository, HrRecordMapper mapper) {
        this.recordRepository = recordRepository;
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HrRecordDto> getAllHrRecords() {
        return repository.findAll().stream()
                .map(mapper::toDto).toList();
    }


    public HrRecord saveNewHrRecord(HrRecordDto dto) {
        var hrRecord = mapper.toEntity(dto);

        recordRepository.save(hrRecord.getRecord());

        hrRecord.setHrUser(repository.getHrByComName(hrRecord.getHrUser().getHrName()));

        List<Record> records = repository.getRecordByComName(hrRecord.getRecord().getCompanyName());

        hrRecord.setRecordTitle(hrRecord.getRecordTitle());
        hrRecord.setHrUser(hrRecord.getHrUser());
        hrRecord.setRecord(records.get(records.size() - 1));

        return repository.save(hrRecord);
    }
}
