package pl.kietlinski.naukajazdy.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dates_of_driving")
public class DrivingDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driving_date_id")
    private long id;
    @Column(name = "driving_date", nullable = false)
    private LocalDate drivingDate;
    @Column(name = "driving_time", nullable = false)
    private LocalTime drivingTime;
    private boolean reserved;
    private boolean confirmed;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Instructor instructor;

    public DrivingDate(LocalDate drivingDate, LocalTime drivingTime, boolean reserved, boolean confirmed) {
        this.drivingDate = drivingDate;
        this.drivingTime = drivingTime;
        this.reserved = reserved;
        this.confirmed = confirmed;
    }
}
