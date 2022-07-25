package javamilos.com.example.demo.repository;

import javamilos.com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    Student findByEmail(String email);
}
