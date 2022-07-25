package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.entity.Student;
import javamilos.com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }
    @GetMapping("/showStudentsForm")
    public String getAllUsers(Model model){
        model.addAttribute("student", studentRepository.findAll());
        return "/student/student_page";
    }
    @GetMapping("/add_student")
    public String getSaveStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/add-student";
    }
    @PostMapping("/save_student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/student/student_page";
    }
    @GetMapping("/student/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "/student/update_student";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        return "redirect:/showStudentsForm";
    }
}
