package backend.controller;

import backend.dto.SimpleUserDto;
import backend.dto.UserAuthDto;
import backend.dto.UserDto;
import backend.feigh.UserFeign;
import backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserFeign feign;
    private final UserService service;

    public UserController(UserFeign feign, UserService service) {
        this.feign = feign;
        this.service = service;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return service.toUserDtoList(feign.getAllUsers());
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return service.toDto(feign.getUserById(id));
    }

    @PostMapping("/user/new")
    public void saveUser(@RequestBody UserAuthDto userAuthDto) {
        feign.createUser(userAuthDto);
    }

    @PostMapping("/user/super/new")
    public void createSuperUser(@RequestBody UserAuthDto userAuthDto) {
        feign.createSuperUser(userAuthDto);
    }

    @PostMapping("/user/super/new_user/{role}")
    public void createUserBySuperUser(@PathVariable String role, @RequestBody SimpleUserDto userAuthDto) {
        feign.createUserBySuperUser(role, userAuthDto);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        feign.deleteUser(id);
    }
}
