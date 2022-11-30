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
@Table(name = "hr_user")
public class HrUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hr_user_id;

    @NotNull
    private String hrName;

    @Override
    public String toString() {
        return "HrUser{" +
                "id=" + hr_user_id +
                ", hrName='" + hrName + '\'' +
                ", company=" + company +
                '}';
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
