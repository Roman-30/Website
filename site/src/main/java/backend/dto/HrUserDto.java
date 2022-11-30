package backend.dto;

import lombok.Data;

@Data
public class HrUserDto {
    private Integer hr_user_id;

    private String hrName;

    private CompanyDto company;
}
