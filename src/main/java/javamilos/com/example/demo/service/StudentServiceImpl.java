package javamilos.com.example.demo.service;

import javamilos.com.example.demo.dto.StudentDto;
import javamilos.com.example.demo.entity.Employee;
import javamilos.com.example.demo.entity.Student;
import javamilos.com.example.demo.exceptions.StudentNotFoundException;
import javamilos.com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * @param stu
     * @return Student found by email
     * @throws StudentNotFoundException
     */

//    public Student loadStudentByUsername(String stu) throws StudentNotFoundException {
//        Student student = studentRepository.findByEmail(stu);
//        if(student == null) {
//            throw new StudentNotFoundException("Invalid username or password.");
//        }
//        return new Student(student.getEmail(), student.getPassword(), student.getFirstName(), student.getSchoolClass(), student.getLastName());
//    }

    /**
     * @return
     */
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(long id) {
        Optional<Student> stu = studentRepository.findById(id);
        Student student = null;
        if (stu.isPresent()){
            student = stu.get();
        }else {
            throw new RuntimeException("Employee with " + id + "dose not exist");
        }
        return student;
    }

    /**
     * @param student 
     */
    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void saveStudent(Student stu) {
        if(!stu.equals(null)){
            stu.setPassword(passwordEncoder.encode(stu.getPassword()));
        }
        studentRepository.save(stu);
    }

}
