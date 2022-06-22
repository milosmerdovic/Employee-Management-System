package javamilos.com.example.demo.service;

import javamilos.com.example.demo.entity.Employee;
import javamilos.com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * @return list of all employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * @param employee
     * Saves employee in database
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * @param id
     * Search for employee using id passed to method then returns it
     * @return employee with exact id if exist in database
     */
    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        Employee employee = null;
        if (emp.isPresent()){
            employee = emp.get();
        }else {
             throw new RuntimeException("Employee with " + id + "dose not exist");
        }
        return employee;
    }

    /**
     * @param id
     * Deletes employee with given id
     */
    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }
}
