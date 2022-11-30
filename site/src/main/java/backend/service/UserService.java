package backend.service;

import backend.dto.UserDto;
import backend.entity.User;
import backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserMapper mapper;

    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public List<UserDto> toUserDtoList(List<User> users) {
        return users.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto toDto(User user) {
        return mapper.toDto(user);
    }
}
