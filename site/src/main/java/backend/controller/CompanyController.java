package backend.controller;

import backend.dto.CompanyDto;
import backend.entity.Company;
import backend.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/companies")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<CompanyDto> getAllCompanies() {
        return service.getAllCompanies();
    }

    @PostMapping("/company/new")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<Company> addCompany(@RequestBody CompanyDto dto) {
        return new ResponseEntity<>(service.saveNewCompanies(dto), HttpStatus.CREATED);
    }

    @PutMapping("/company/edit")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void editCompany(@RequestBody CompanyDto dto) {
        service.editCompany(dto);
    }

    @DeleteMapping("/company/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public void deleteCompanyById(@PathVariable Integer id) {
        service.removeCompany(id);
    }

    @GetMapping("/company/{id}")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public CompanyDto getCompanyById(@PathVariable Integer id) {
        return service.getCompany(id);
    }

    @GetMapping("/company/emails/{name}")
    public List<String> getEmailsByName(@PathVariable String name) {
        return service.getCompanyEmails(name);
    }

    @GetMapping("/company/hrs/{name}")
    public List<String> getHrsByName(@PathVariable String name) {
        return service.getCompanyHrs(name);
    }
}
