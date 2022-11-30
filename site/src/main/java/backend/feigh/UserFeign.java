package backend.feigh;

import backend.dto.SimpleUserDto;
import backend.dto.UserAuthDto;
import backend.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "UserFeign", url = "http://localhost:80")
public interface UserFeign {

    @GetMapping("/reviews/users/")
    List<User> getAllUsers();

    @GetMapping("/reviews/users/{user_id}")
    User getUserById(@PathVariable Integer user_id);

    @PostMapping("/reviews/users/user")
    UserAuthDto createUser(@RequestBody UserAuthDto userAuthDto);

    @PostMapping("/reviews/users/superuser")
    UserAuthDto createSuperUser(@RequestBody UserAuthDto userAuthDto);

    @PostMapping("/reviews/users/superuser/new_user/{role}")
    SimpleUserDto createUserBySuperUser(@PathVariable String role, @RequestBody SimpleUserDto userAuth);

    @DeleteMapping("/reviews/users/{user_id}")
    void deleteUser(@PathVariable Integer user_id);

}

