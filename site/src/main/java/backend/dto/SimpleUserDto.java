package backend.dto;

import lombok.Data;

@Data
public class SimpleUserDto {
    private String name;

    private String email;

    private String password;
}
