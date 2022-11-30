package backend.repository;

import backend.entity.Company;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @NotNull
    List<Company> findAll();

    @Query("SELECT e.email FROM HrEmail e WHERE e.company.company_id = " +
            "(select c.company_id from Company c where c.companyName = :name)")
    List<String> getAllCompanyEmails(String name);

    @Query("SELECT e.hrName FROM HrUser e WHERE e.company.company_id = " +
            "(select c.company_id from Company c where c.companyName = :name)")
    List<String> getAllCompanyHrs(String name);
}
