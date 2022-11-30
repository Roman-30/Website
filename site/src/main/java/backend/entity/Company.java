package backend.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;

    @NotNull
    private String companyName;

    private Float rating;

    @NotNull
    @OneToMany
    @JoinColumn(name = "email_id")
    private List<HrEmail> emails;


    @NotNull
    @OneToMany
    @JoinColumn(name = "hr_user_id")
    private List<HrUser> hrUsers;

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", companyName='" + companyName + '\'' +
                ", rating=" + rating +
                ", emails=" + emails +
                ", hrUsers=" + hrUsers +
                '}';
    }
}
