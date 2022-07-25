package javamilos.com.example.demo.service;

import javamilos.com.example.demo.dto.StudentDto;
import javamilos.com.example.demo.entity.Student;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StudentService {
    Student saveStudent(StudentDto studentDto);
}
