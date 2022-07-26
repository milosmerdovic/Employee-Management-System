package javamilos.com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = "student_email"))
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String
            firstName,
            lastName,
            schoolClass,
            password;
    @Column(name = "student_email")
    private String email;
}
