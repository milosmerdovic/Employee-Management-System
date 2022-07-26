package javamilos.com.example.demo.service;

import javamilos.com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    void saveStudent(Student student);
    Student findStudentById(long id);
    void deleteStudent(Student student);

}
