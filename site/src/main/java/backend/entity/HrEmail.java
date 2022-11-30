package backend.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "hr_email")
public class HrEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer email_id;

    @NotNull
    private String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public String toString() {
        return "HrEmail{" +
                "email_id=" + email_id +
                ", email='" + email + '\'' +
                ", company=" + company +
                '}';
    }
}
