package backend.service;

import backend.dto.HrEmailDto;
import backend.entity.Company;
import backend.entity.HrEmail;
import backend.mapper.HrEmailMapper;
import backend.repository.HrEmailRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HrEmailService {

    private final HrEmailRepository repository;
    private final HrEmailMapper mapper;

    public HrEmailService(HrEmailRepository repository, HrEmailMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HrEmailDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteEmail(Integer id) {
        repository.delete(findByIndex(id));
    }

    public HrEmail saveNewEmail(HrEmailDto dto) {
        var email = new HrEmail();
        email.setEmail(dto.getEmail());
        var val = repository.findAll().stream()
                .filter(cur -> Objects.equals(dto.getCompany()
                        .getCompanyName(), cur.getCompany()
                        .getCompanyName())
                ).findFirst().orElseThrow().getCompany();
        email.setCompany(val);
        return repository.save(email);
    }

    public HrEmail findByIndex(Integer id) {
        Optional<HrEmail> optionalUser = repository.findAll()
                .stream().filter(com -> com.getEmail_id().equals(id))
                .findFirst();
        return optionalUser.orElseGet(optionalUser::orElseThrow);
    }

    public HrEmailDto getEmail(Integer id) {
        return mapper.toDto(findByIndex(id));
    }

    public List<HrEmailDto> getAllCompanyEmails(String name) {
        return repository.findAll().stream()
                .filter(emails -> emails.getCompany().getCompanyName().equals(name))
                .map(mapper::toDto).toList();
    }

    public void editEmail(HrEmailDto dto) {
        var hrEmail = new HrEmail();
        hrEmail.setEmail_id(dto.getEmail_id());
        hrEmail.setEmail(dto.getEmail());
        hrEmail.setCompany(repository.getCompanyByName(dto.getCompany().getCompanyName()));
        repository.save(hrEmail);
    }
}
