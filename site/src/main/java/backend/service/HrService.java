package backend.service;

import backend.dto.HrUserDto;
import backend.entity.HrUser;
import backend.mapper.HrUserMapper;
import backend.repository.HrRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HrService {

    private final HrRepository repository;
    private final HrUserMapper userMapper;

    public HrService(HrRepository repository, HrUserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public List<HrUserDto> getAll() {
        return repository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public void addNewHr(HrUserDto dto) {
        HrUser user = new HrUser();
        user.setHrName(dto.getHrName());
//        HrUser user = userMapper.toEntity(dto);
        user.setCompany(repository.getCompanyByName(dto.getCompany().getCompanyName()));
        repository.save(user);
    }

    public HrUser updateHRUser(HrUserDto dto) {
        HrUser hr = repository.getHrUserByName(dto.getHrName());
        hr.setCompany(repository.getCompanyByName(dto.getCompany().getCompanyName()));
        return repository.save(hr);
    }

    public HrUser findById(Integer id) {
        Optional<HrUser> optionalUser = repository.findAll()
                .stream().filter(com -> com.getHr_user_id().equals(id))
                .findFirst();
        return optionalUser.orElseGet(optionalUser::orElseThrow);
    }

    public HrUserDto getUser(Integer id) {
        return userMapper.toDto(findById(id));
    }

    public List<HrUserDto> getAllCompanyHrs(String name) {
        return repository.findAll().stream()
                .filter(hrUser -> hrUser.getCompany().getCompanyName().equals(name))
                .map(userMapper::toDto).toList();
    }
}
