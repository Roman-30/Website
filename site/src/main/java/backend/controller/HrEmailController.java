package backend.controller;

import backend.dto.HrEmailDto;
import backend.entity.HrEmail;
import backend.service.HrEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HrEmailController {

    private final HrEmailService service;

    public HrEmailController(HrEmailService service) {
        this.service = service;
    }

    @GetMapping("/emails")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<HrEmailDto> getAllEmails() {
        return service.getAll();
    }

    @PostMapping("/email/new")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<HrEmail> saveEmail(@RequestBody HrEmailDto emails) {
        return new ResponseEntity<>(service.saveNewEmail(emails), HttpStatus.CREATED);
    }

    @DeleteMapping("/email/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void deleteEmail(@PathVariable Integer id) {
        service.deleteEmail(id);
    }

    @GetMapping("/email/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public HrEmailDto getEmailById(@PathVariable Integer id) {
        return service.getEmail(id);
    }

    @GetMapping("/emails/{name}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<HrEmailDto> getCompanyEmails(@PathVariable String name) {
        return service.getAllCompanyEmails(name);
    }

    @PutMapping("/email/edit")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void editHrEmail(@RequestBody HrEmailDto dto) {
        service.editEmail(dto);
    }
}
