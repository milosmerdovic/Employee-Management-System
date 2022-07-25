package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.entity.School;
import javamilos.com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class CompanyController {
    private final SchoolRepository schoolRepository;

    @Autowired
    public CompanyController(SchoolRepository schoolRepository) {
         this.schoolRepository = schoolRepository;
    }
    @GetMapping("/company")
    public String showCompanyForm(School school) {
        return "/company/company";
    }

    @GetMapping("/create")
    public String addCompanyPage(School school) {
        return "/company/add-company";
    }

    @PostMapping("/company/add-company")
    public String addCompany(@Valid School school, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-company";
        }
        schoolRepository.save(school);
        model.addAttribute("companies", schoolRepository.findAll());
        return "redirect:/company/index";
    }

    @GetMapping("/company/edit-company/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        School school = schoolRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid company Id:" + id));
        model.addAttribute("company", school);
        return "company/update-company";
    }

    @PostMapping("/company/update-company/{id}")
    public String updateCompany(@PathVariable("id") long id, @Valid School school, BindingResult result, Model model) {
        if (result.hasErrors()) {
            school.setId(id);
            return "company/update-company";
        }
        schoolRepository.save(school);
        model.addAttribute("companies", schoolRepository.findAll());
        return "company/index";
    }

    @GetMapping("/company/delete-company/{id}")
    public String deleteCompany(@PathVariable("id") long id, Model model) {
        School school = schoolRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid company Id:" + id));
        schoolRepository.delete(school);
        model.addAttribute("companies", schoolRepository.findAll());
        return "company/index";
    }

    @GetMapping("/company/index")
    public String allCompanies(Model model){
        model.addAttribute("companies", schoolRepository.findAll());
        return "company/index";
    }
}