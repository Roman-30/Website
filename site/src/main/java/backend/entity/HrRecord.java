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
@Table(name = "hr_record")
public class HrRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String recordTitle;

    @NotNull
    @OneToOne
    @JoinColumn(name = "record_id")
    private Record record;

    @NotNull
    @OneToOne
    @JoinColumn(name = "hr_id")
    private HrUser hrUser;

    @Override
    public String toString() {
        return "HrRecord{" +
                "id=" + id +
                ", recordTitle='" + recordTitle + '\'' +
                ", record=" + record +
                ", hrUser=" + hrUser +
                '}';
    }
}
