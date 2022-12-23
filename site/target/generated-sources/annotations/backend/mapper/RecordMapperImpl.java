package backend.mapper;

import backend.dto.RecordDto;
import backend.entity.Record;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-23T09:11:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class RecordMapperImpl implements RecordMapper {

    @Override
    public RecordDto toDto(Record record) {
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

    @Override
    public Record toEntity(RecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        Record record = new Record();

        if ( dto.getRating() != null ) {
            record.setRating( dto.getRating().intValue() );
        }
        record.setReview( dto.getReview() );
        record.setCompanyName( dto.getCompanyName() );

        return record;
    }
}
