package pl.kietlinski.naukajazdy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.naukajazdy.Entity.DrivingDate;

@Repository
public interface DrivingDateRepository extends JpaRepository<DrivingDate, Long> {
}
