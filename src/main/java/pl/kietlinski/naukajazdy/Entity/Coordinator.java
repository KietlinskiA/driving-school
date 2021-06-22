package pl.kietlinski.naukajazdy.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kietlinski.naukajazdy.Model.AccountType;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coordinators")
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinator_id")
    private long id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(nullable = false, length = 30)
    private String login;
    @Column(nullable = false, length = 30)
    private String password;
    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany(mappedBy = "coordinator")
    private Set<Instructor> instructorSet;

    public Coordinator(String name, String surname, String login, String password, AccountType accountType) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }
}
