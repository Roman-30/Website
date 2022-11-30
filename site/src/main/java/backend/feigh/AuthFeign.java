package backend.feigh;

import backend.dto.AuthDto;
import backend.dto.TokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AuthFeign", url = "http://localhost:80")
public interface AuthFeign {

    @PostMapping("/reviews/login")
    TokenDto login(@RequestBody AuthDto authDto);
}
