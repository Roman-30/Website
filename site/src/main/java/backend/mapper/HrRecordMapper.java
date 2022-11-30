package backend.mapper;


import backend.dto.HrRecordDto;
import backend.entity.HrRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HrRecordMapper {
    HrRecordDto toDto(HrRecord hrRecord);

    HrRecord toEntity(HrRecordDto dto);
}
