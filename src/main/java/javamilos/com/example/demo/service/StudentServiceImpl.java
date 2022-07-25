package javamilos.com.example.demo.service;

import javamilos.com.example.demo.dto.StudentDto;
import javamilos.com.example.demo.entity.Student;
import javamilos.com.example.demo.exceptions.StudentNotFoundException;
import javamilos.com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    /**
     * @param stu
     * @return Student found by email
     * @throws StudentNotFoundException
     */

    public Student loadStudentByUsername(String stu) throws StudentNotFoundException {
        Student student = studentRepository.findByEmail(stu);
        if(student == null) {
            throw new StudentNotFoundException("Invalid username or password.");
        }
        return new Student(student.getEmail(), student.getPassword(), student.getFirstName(), student.getLastName());
    }

    @Override
    public Student saveStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getFirstName(),
                studentDto.getLastName(), studentDto.getEmail(),
                passwordEncoder.encode(studentDto.getPassword()));

        return studentRepository.save(student);
    }
}
