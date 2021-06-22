package pl.kietlinski.naukajazdy.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor implements UserDetails {
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
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "instructor")
    private Set<DrivingDate> drivingDateSet;

    @ManyToOne
    private Coordinator coordinator;

    public Instructor(String name, String surname, int workedHours, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.workedHours = workedHours;
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
