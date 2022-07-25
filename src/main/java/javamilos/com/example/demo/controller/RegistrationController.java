package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.dto.StudentDto;
import javamilos.com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final StudentService studentService;

    public RegistrationController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @ModelAttribute("student")
    public StudentDto userRegistrationDto() {
        return new StudentDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") StudentDto registrationDto) {
        studentService.saveStudent(registrationDto);
        return "redirect:/registration?success";
    }

}
