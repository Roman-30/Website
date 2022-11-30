package backend.mapper;

import backend.dto.CompanyDto;
import backend.dto.HrRecordDto;
import backend.dto.HrUserDto;
import backend.dto.RecordDto;
import backend.entity.Company;
import backend.entity.HrRecord;
import backend.entity.HrUser;
import backend.entity.Record;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-29T07:56:33+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class HrRecordMapperImpl implements HrRecordMapper {

    @Override
    public HrRecordDto toDto(HrRecord hrRecord) {
        if ( hrRecord == null ) {
            return null;
        }

        HrRecordDto hrRecordDto = new HrRecordDto();

        hrRecordDto.setId( hrRecord.getId() );
        hrRecordDto.setRecordTitle( hrRecord.getRecordTitle() );
        hrRecordDto.setRecord( recordToRecordDto( hrRecord.getRecord() ) );
        hrRecordDto.setHrUser( hrUserToHrUserDto( hrRecord.getHrUser() ) );

        return hrRecordDto;
    }

    @Override
    public HrRecord toEntity(HrRecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        HrRecord hrRecord = new HrRecord();

        hrRecord.setId( dto.getId() );
        hrRecord.setRecordTitle( dto.getRecordTitle() );
        hrRecord.setRecord( recordDtoToRecord( dto.getRecord() ) );
        hrRecord.setHrUser( hrUserDtoToHrUser( dto.getHrUser() ) );

        return hrRecord;
    }

    protected RecordDto recordToRecordDto(Record record) {
        if ( record == null ) {
            return null;
        }

        RecordDto recordDto = new RecordDto();

        if ( record.getRating() != null ) {
            recordDto.setRating( record.getRating().floatValue() );
        }
        recordDto.setReview( record.getReview() );
        recordDto.setCompanyName( record.getCompanyName() );

        return recordDto;
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

    protected HrUserDto hrUserToHrUserDto(HrUser hrUser) {
        if ( hrUser == null ) {
            return null;
        }

        HrUserDto hrUserDto = new HrUserDto();

        hrUserDto.setHr_user_id( hrUser.getHr_user_id() );
        hrUserDto.setHrName( hrUser.getHrName() );
        hrUserDto.setCompany( companyToCompanyDto( hrUser.getCompany() ) );

        return hrUserDto;
    }

    protected Record recordDtoToRecord(RecordDto recordDto) {
        if ( recordDto == null ) {
            return null;
        }

        Record record = new Record();

        if ( recordDto.getRating() != null ) {
            record.setRating( recordDto.getRating().intValue() );
        }
        record.setReview( recordDto.getReview() );
        record.setCompanyName( recordDto.getCompanyName() );

        return record;
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

    protected HrUser hrUserDtoToHrUser(HrUserDto hrUserDto) {
        if ( hrUserDto == null ) {
            return null;
        }

        HrUser hrUser = new HrUser();

        hrUser.setHr_user_id( hrUserDto.getHr_user_id() );
        hrUser.setHrName( hrUserDto.getHrName() );
        hrUser.setCompany( companyDtoToCompany( hrUserDto.getCompany() ) );

        return hrUser;
    }
}
