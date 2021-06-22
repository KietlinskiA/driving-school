package pl.kietlinski.naukajazdy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.naukajazdy.Entity.Coordinator;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
}
