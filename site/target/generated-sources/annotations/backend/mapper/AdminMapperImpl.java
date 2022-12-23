package backend.mapper;

import backend.dto.AdminDto;
import backend.entity.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-23T09:11:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDto toDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDto adminDto = new AdminDto();

        adminDto.setAdminName( admin.getAdminName() );

        return adminDto;
    }

    @Override
    public Admin toEntity(AdminDto dto) {
        if ( dto == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setAdminName( dto.getAdminName() );

        return admin;
    }
}
