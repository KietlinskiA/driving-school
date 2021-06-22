package pl.kietlinski.naukajazdy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kietlinski.naukajazdy.Entity.Coordinator;
import pl.kietlinski.naukajazdy.Entity.DrivingDate;
import pl.kietlinski.naukajazdy.Entity.Instructor;
import pl.kietlinski.naukajazdy.Entity.Student;
import pl.kietlinski.naukajazdy.Model.AccountType;
import pl.kietlinski.naukajazdy.Repository.CoordinatorRepository;
import pl.kietlinski.naukajazdy.Repository.DrivingDateRepository;
import pl.kietlinski.naukajazdy.Repository.InstructorRepository;
import pl.kietlinski.naukajazdy.Repository.StudentRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private InstructorRepository instructorRepository;
    private CoordinatorRepository coordinatorRepository;
    private DrivingDateRepository drivingDateRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, InstructorRepository instructorRepository, CoordinatorRepository coordinatorRepository, DrivingDateRepository drivingDateRepository) {
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.coordinatorRepository = coordinatorRepository;
        this.drivingDateRepository = drivingDateRepository;
    }

    public void init() {
        Student student1 = new Student("Maciek", "Walczak",	0, "maciek1", "pass", AccountType.STUDENT);
        Student student2 = new Student("Michał", "Kafin",	0, "michal1", "pass", AccountType.STUDENT);
        Student student3 = new Student("Bartosz", "Sołtys",	0, "bartosz1", "pass", AccountType.STUDENT);
        Instructor instructor1 = new Instructor("Marcel", "Misa", 0, "marcel1", "pass", AccountType.INSTRUCTOR);
        Instructor instructor2 = new Instructor("Kamil", "Ojzyn", 0, "kamil1", "pass", AccountType.INSTRUCTOR);
        Instructor instructor3 = new Instructor("Filip", "Korcinowicz", 0, "filip1", "pass", AccountType.INSTRUCTOR);
        Coordinator coordinator1 = new Coordinator("Karol", "Kuracz", "karol1", "pass", AccountType.COORDYNATOR);
        Coordinator coordinator2 = new Coordinator("Justyna", "Opalska", "justyna1", "pass", AccountType.COORDYNATOR);
        Coordinator coordinator3 = new Coordinator("Krystyna", "Czubówna", "krystyna1", "pass", AccountType.COORDYNATOR);
        DrivingDate drivingDate1 = new DrivingDate(LocalDate.now(), LocalTime.now(), false, false);
        DrivingDate drivingDate2 = new DrivingDate(LocalDate.now(), LocalTime.now(), true, false);
        DrivingDate drivingDate3 = new DrivingDate(LocalDate.now(), LocalTime.now(), true, true);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        coordinatorRepository.save(coordinator1);
        coordinatorRepository.save(coordinator2);
        coordinatorRepository.save(coordinator3);
        drivingDateRepository.save(drivingDate1);
        drivingDateRepository.save(drivingDate2);
        drivingDateRepository.save(drivingDate3);
    }
}
