package pl.kietlinski.naukajazdy.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kietlinski.naukajazdy.Model.AccountType;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(name = "remaining_hours")
    private int remainingHours;
    @Column(nullable = false, length = 30)
    private String login;
    @Column(nullable = false, length = 30)
    private String password;
    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "student")
    private Set<DrivingDate> drivingDateSet;

    public Student(String name, String surname, int remainingHours, String login, String password, AccountType accountType) {
        this.name = name;
        this.surname = surname;
        this.remainingHours = remainingHours;
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }
}
