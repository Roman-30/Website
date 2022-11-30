package backend.mapper;

import backend.dto.HrUserDto;
import backend.entity.HrUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HrUserMapper {
    HrUserDto toDto(HrUser user);

    HrUser toEntity(HrUserDto dto);
}
