package pl.kietlinski.naukajazdy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.naukajazdy.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
