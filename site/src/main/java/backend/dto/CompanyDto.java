package backend.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private Integer company_id;

    private String companyName;

    private Float rating;
}
