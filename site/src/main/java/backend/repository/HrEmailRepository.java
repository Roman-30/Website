package backend.repository;

import backend.entity.Company;
import backend.entity.HrEmail;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HrEmailRepository extends CrudRepository<HrEmail, Integer> {
    @NotNull
    List<HrEmail> findAll();

    @Query("SELECT com FROM Company com WHERE com.companyName = :name")
    Company getCompanyByName(String name);

}
