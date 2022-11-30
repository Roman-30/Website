package backend.repository;

import backend.entity.HrRecord;
import backend.entity.HrUser;
import backend.entity.Record;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HrRecordRepository extends CrudRepository<HrRecord,Integer> {
    @NotNull
    List<HrRecord> findAll();

    @Query("SELECT d FROM HrUser d WHERE d.hrName = :name")
    HrUser getHrByComName(String name);

    @Query("SELECT d FROM Record d WHERE d.companyName = :name")
    List<Record> getRecordByComName(String name);
}
