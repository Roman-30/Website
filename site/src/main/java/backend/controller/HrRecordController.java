package backend.controller;

import backend.dto.HrRecordDto;
import backend.entity.HrRecord;
import backend.service.HrRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HrRecordController {
    private final HrRecordService service;

    public HrRecordController(HrRecordService service) {
        this.service = service;
    }

    @GetMapping("/hr/records")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<HrRecordDto> getAllHrRecords() {
        return service.getAllHrRecords();
    }

    @PostMapping("/hr/record/new")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<HrRecord> saveHrRecord(@RequestBody HrRecordDto dto) {
        return new ResponseEntity<>(service.saveNewHrRecord(dto), HttpStatus.CREATED);
    }
}
