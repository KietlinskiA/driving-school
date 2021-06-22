package pl.kietlinski.naukajazdy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kietlinski.naukajazdy.Entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Instructor findInstructorByUsername(String username);
}
