package backend.dto;

import lombok.Data;

@Data
public class UserAuthDto {

    private String name;

    private String email;

    private String password;

    private String role;
}
