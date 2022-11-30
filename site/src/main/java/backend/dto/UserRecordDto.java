package backend.dto;

import lombok.Data;

@Data
public class UserRecordDto {

    private RecordDto record;

    private String company_name;

    private String record_title;
}
