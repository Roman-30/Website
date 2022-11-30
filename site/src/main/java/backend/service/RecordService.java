package backend.service;

import backend.dto.RecordDto;
import backend.entity.Record;
import backend.mapper.RecordMapper;
import backend.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    private final RecordMapper mapper;
    private final RecordRepository repository;

    public RecordService(RecordMapper mapper, RecordRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private Record findByIndex(Integer id) {
        return repository.findAll()
                .stream().filter(com -> com.getRecord_id()
                        .equals(id)).toList().get(0);
    }

    public void deleteRecord(Integer id) {
        repository.delete(findByIndex(id));
    }

    public void addNewRecord(RecordDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    public List<Record> getAll() {
        return repository.findAll();
//                .stream().map(mapper::toDto)
//                .collect(Collectors.toList());
    }
}
