package javamilos.com.example.demo.dto;

public class StudentDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String schoolClass;

    public StudentDto(){}
    public StudentDto(String firstName, String lastName, String email, String password, String schoolClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.schoolClass = schoolClass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }
}
