package pl.kietlinski.naukajazdy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kietlinski.naukajazdy.Repository.StudentRepository;
import pl.kietlinski.naukajazdy.Service.StudentService;

import java.security.Principal;

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

    @GetMapping
    public String getUsers(Principal principal) {
        return "LOG IN " + principal.getName();
    }

}
