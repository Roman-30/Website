package backend.controller;

import backend.dto.HrUserDto;
import backend.entity.HrUser;
import backend.service.HrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HrController {
    private final HrService service;

    public HrController(HrService service) {
        this.service = service;
    }

    @GetMapping("/users/hrs")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<HrUserDto> getAllHrs() {
        return service.getAll();
    }

    @PutMapping("/user/hr/update")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<HrUser> updateHrUser(@RequestBody HrUserDto user) {
        return new ResponseEntity<>(service.updateHRUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/user/hr/new")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void addHrUser(@RequestBody HrUserDto user) {
       service.addNewHr(user);
    }

    @GetMapping("/user/hr/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public HrUserDto getHrById(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @GetMapping("/users/hrs/{name}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<HrUserDto> getCompanyHrs(@PathVariable String name) {
        return service.getAllCompanyHrs(name);
    }

}
