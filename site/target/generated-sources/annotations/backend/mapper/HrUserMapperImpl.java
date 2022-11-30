package backend.mapper;

import backend.dto.CompanyDto;
import backend.dto.HrUserDto;
import backend.entity.Company;
import backend.entity.HrUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T07:56:33+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class HrUserMapperImpl implements HrUserMapper {

    @Override
    public HrUserDto toDto(HrUser user) {
        if ( user == null ) {
            return null;
        }

        HrUserDto hrUserDto = new HrUserDto();

        hrUserDto.setHr_user_id( user.getHr_user_id() );
        hrUserDto.setHrName( user.getHrName() );
        hrUserDto.setCompany( companyToCompanyDto( user.getCompany() ) );

        return hrUserDto;
    }

    @Override
    public HrUser toEntity(HrUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        HrUser hrUser = new HrUser();

        hrUser.setHr_user_id( dto.getHr_user_id() );
        hrUser.setHrName( dto.getHrName() );
        hrUser.setCompany( companyDtoToCompany( dto.getCompany() ) );

        return hrUser;
    }

    protected CompanyDto companyToCompanyDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setCompany_id( company.getCompany_id() );
        companyDto.setCompanyName( company.getCompanyName() );
        companyDto.setRating( company.getRating() );

        return companyDto;
    }

    protected Company companyDtoToCompany(CompanyDto companyDto) {
        if ( companyDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setCompany_id( companyDto.getCompany_id() );
        company.setCompanyName( companyDto.getCompanyName() );
        company.setRating( companyDto.getRating() );

        return company;
    }
}
