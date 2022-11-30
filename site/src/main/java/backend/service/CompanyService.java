package backend.service;

import backend.dto.CompanyDto;
import backend.entity.Company;
import backend.mapper.CompanyMapper;
import backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository, CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private final CompanyMapper mapper;

    public void editCompany(CompanyDto dto) {
        Company company = new Company();
        company.setCompany_id(dto.getCompany_id());
        company.setCompanyName(dto.getCompanyName());
        company.setRating(dto.getRating());
        repository.save(company);
    }

    public void removeCompany(Integer id) {
        repository.delete(findByIndex(id));
    }

    public List<CompanyDto> getAllCompanies() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private Company findByIndex(Integer id) {
        return repository.findAll()
                .stream().filter(com -> com.getCompany_id()
                        .equals(id)).toList().get(0);
    }

    public Company saveNewCompanies(CompanyDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public CompanyDto getCompany(Integer id) {

        return mapper.toDto(findByIndex(id));
    }

    public List<String> getCompanyEmails(String name) {
        return repository.getAllCompanyEmails(name);
    }

    public List<String> getCompanyHrs(String name) {
        return repository.getAllCompanyHrs(name);
    }
}
