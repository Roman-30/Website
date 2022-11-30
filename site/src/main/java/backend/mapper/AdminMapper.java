package backend.mapper;

import backend.dto.AdminDto;
import backend.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDto toDto(Admin admin);

    Admin toEntity(AdminDto dto);
}
