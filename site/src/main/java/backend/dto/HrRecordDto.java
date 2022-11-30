package backend.dto;

import lombok.Data;

@Data
public class HrRecordDto {

    private Integer id;

    private String recordTitle;

    private RecordDto record;

    private HrUserDto hrUser;
}
