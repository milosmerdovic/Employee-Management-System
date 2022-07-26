package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.entity.Student;
import javamilos.com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/backToStudents")
    public String goBack(){
        return "redirect:/showStudentsForm";
    }
    @GetMapping("/showStudentsForm")
    public String getAllUsers(Model model){
        model.addAttribute("students", studentService.findAllStudents());
        return "/student/student_page";
    }

    @GetMapping("/add_student")
    public String getSaveStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/add_student";
    }
    @PostMapping("/save_student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/showStudentsForm";
    }

    @GetMapping("/studentFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "/student/update_student";
    }

    @GetMapping("/deleteStudentForm/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        Student student = studentService.findStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/showStudentsForm";
    }
}
