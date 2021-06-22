package pl.kietlinski.naukajazdy.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kietlinski.naukajazdy.Model.AccountType;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private long id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(name = "worked_hours")
    private int workedHours;
    @Column(nullable = false, length = 30)
    private String login;
    @Column(nullable = false, length = 30)
    private String password;
    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "instructor")
    private Set<DrivingDate> drivingDateSet;

    @ManyToOne
    private Coordinator coordinator;

    public Instructor(String name, String surname, int workedHours, String login, String password, AccountType accountType) {
        this.name = name;
        this.surname = surname;
        this.workedHours = workedHours;
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }
}
