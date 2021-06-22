package pl.kietlinski.naukajazdy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kietlinski.naukajazdy.Entity.Student;
import pl.kietlinski.naukajazdy.Repository.StudentRepository;
import pl.kietlinski.naukajazdy.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping
public class MainController {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @Autowired
    public MainController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping("/users")
    public List<Student> getUsers() {
        studentService.init();
        return studentRepository.findAll();
    }
}
