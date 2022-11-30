package backend.dto;

import lombok.Data;

@Data
public class HrEmailDto {
    private Integer email_id;

    private String email;

    private CompanyDto company;
}
