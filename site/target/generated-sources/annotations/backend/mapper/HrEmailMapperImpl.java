package backend.mapper;

import backend.dto.CompanyDto;
import backend.dto.HrEmailDto;
import backend.entity.Company;
import backend.entity.HrEmail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-23T09:11:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class HrEmailMapperImpl implements HrEmailMapper {

    @Override
    public HrEmailDto toDto(HrEmail email) {
        if ( email == null ) {
            return null;
        }

        HrEmailDto hrEmailDto = new HrEmailDto();

        hrEmailDto.setEmail_id( email.getEmail_id() );
        hrEmailDto.setEmail( email.getEmail() );
        hrEmailDto.setCompany( companyToCompanyDto( email.getCompany() ) );

        return hrEmailDto;
    }

    @Override
    public HrEmail toEntity(HrEmailDto dto) {
        if ( dto == null ) {
            return null;
        }

        HrEmail hrEmail = new HrEmail();

        hrEmail.setEmail_id( dto.getEmail_id() );
        hrEmail.setEmail( dto.getEmail() );
        hrEmail.setCompany( companyDtoToCompany( dto.getCompany() ) );

        return hrEmail;
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
