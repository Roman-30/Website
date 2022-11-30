package backend.mapper;

import backend.dto.CompanyDto;
import backend.entity.Company;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T07:56:33+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDto toDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setCompany_id( company.getCompany_id() );
        companyDto.setCompanyName( company.getCompanyName() );
        companyDto.setRating( company.getRating() );

        return companyDto;
    }

    @Override
    public Company toEntity(CompanyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Company company = new Company();

        company.setCompany_id( dto.getCompany_id() );
        company.setCompanyName( dto.getCompanyName() );
        company.setRating( dto.getRating() );

        return company;
    }
}
