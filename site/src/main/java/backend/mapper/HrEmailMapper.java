package backend.mapper;

import backend.dto.HrEmailDto;
import backend.entity.HrEmail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HrEmailMapper {
    HrEmailDto toDto(HrEmail email);

    HrEmail toEntity(HrEmailDto dto);
}
