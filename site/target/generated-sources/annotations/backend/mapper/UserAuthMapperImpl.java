package backend.mapper;

import backend.dto.UserAuthDto;
import backend.entity.UserAuth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T07:56:33+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class UserAuthMapperImpl implements UserAuthMapper {

    @Override
    public UserAuthDto toDto(UserAuth userAuth) {
        if ( userAuth == null ) {
            return null;
        }

        UserAuthDto userAuthDto = new UserAuthDto();

        userAuthDto.setName( userAuth.getName() );
        userAuthDto.setEmail( userAuth.getEmail() );
        userAuthDto.setPassword( userAuth.getPassword() );
        userAuthDto.setRole( userAuth.getRole() );

        return userAuthDto;
    }

    @Override
    public UserAuth toEntity(UserAuthDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserAuth userAuth = new UserAuth();

        userAuth.setName( dto.getName() );
        userAuth.setEmail( dto.getEmail() );
        userAuth.setPassword( dto.getPassword() );
        userAuth.setRole( dto.getRole() );

        return userAuth;
    }
}
