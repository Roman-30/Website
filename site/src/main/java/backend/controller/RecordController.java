package backend.controller;

import backend.dto.RecordDto;
import backend.entity.Record;
import backend.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }


    @GetMapping("/records")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<Record> getAllRecords() {
        return service.getAll();
    }

    @DeleteMapping("/records/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void deleteRecord(@PathVariable Integer id) {
        service.deleteRecord(id);
    }

    @PostMapping("/records/new")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void addRecord(@RequestBody RecordDto dto) {
        service.addNewRecord(dto);
    }
}
