package pl.kietlinski.naukajazdy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kietlinski.naukajazdy.Entity.Coordinator;
import pl.kietlinski.naukajazdy.Entity.Instructor;
import pl.kietlinski.naukajazdy.Entity.Student;
import pl.kietlinski.naukajazdy.Repository.CoordinatorRepository;
import pl.kietlinski.naukajazdy.Repository.InstructorRepository;
import pl.kietlinski.naukajazdy.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private StudentRepository studentRepository;
    private InstructorRepository instructorRepository;
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    public UserDetailsServiceImpl(StudentRepository studentRepository, InstructorRepository instructorRepository, CoordinatorRepository coordinatorRepository) {
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Student> studentList = studentRepository.findAll();
        List<Instructor> instructorList = instructorRepository.findAll();
        List<Coordinator> coordinatorList = coordinatorRepository.findAll();

        Optional<Student> optionalStudent = studentList.stream().filter(student -> student.getUsername().equals(s)).findFirst();
        Optional<Instructor> optionalInstructor = instructorList.stream().filter(instructor -> instructor.getUsername().equals(s)).findFirst();
        Optional<Coordinator> optionalCoordinator = coordinatorList.stream().filter(coordinator -> coordinator.getUsername().equals(s)).findFirst();

        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        } else if(optionalInstructor.isPresent()) {
            return optionalInstructor.get();
        } else if(optionalCoordinator.isPresent()){
            return optionalCoordinator.get();
        } else {
            return new Student();
        }
    }
}
