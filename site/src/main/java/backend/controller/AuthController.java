package backend.controller;

import backend.dto.AuthDto;
import backend.dto.TokenDto;
import backend.feigh.AuthFeign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthFeign feign;

    public AuthController(AuthFeign feign) {
        this.feign = feign;
    }

    @PostMapping("/login")
    public TokenDto logining(@RequestBody AuthDto dto) {
        return feign.login(dto);
    }
}
