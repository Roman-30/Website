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
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer record_id;

    @NotNull
    private Integer rating;

    @NotNull
    private String review;

    @NotNull
    private String companyName;


//    @NotNull
//    @OneToMany
//    @JoinColumn(name = "record_id")
//    private Specialization specialization;
}
