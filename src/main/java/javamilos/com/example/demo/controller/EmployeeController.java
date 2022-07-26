package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.entity.Employee;
import javamilos.com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/backToEmployee")
    public String goBack(){
        return "redirect:/showEmployeePage";
    }

    @GetMapping("/showEmployeePage")
    public String listAllEmployees(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "/employees_page";
    }
    @GetMapping("/addNewEmployee")
    public String addEmployees(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/add_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/showEmployeePage";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/showEmployeePage";
    }
}
