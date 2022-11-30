package backend.mapper;

import backend.dto.UserAuthDto;
import backend.entity.UserAuth;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuthMapper {
    UserAuthDto toDto(UserAuth userAuth);

    UserAuth toEntity(UserAuthDto dto);
}
