package backend.mapper;

import backend.entity.Record;
import backend.dto.RecordDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    RecordDto toDto(Record record);

    Record toEntity(RecordDto dto);
}
