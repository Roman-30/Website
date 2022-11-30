package backend.repository;

import backend.entity.Company;
import backend.entity.HrUser;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HrRepository extends JpaRepository<HrUser, Integer> {
    @NotNull
    List<HrUser> findAll();

    @Query("SELECT com FROM Company com WHERE com.companyName = :name")
    Company getCompanyByName(String name);

    @Query("SELECT hr FROM HrUser hr WHERE hr.hrName = :name")
    HrUser getHrUserByName(String name);
}
