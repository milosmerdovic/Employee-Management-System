package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.entity.Company;
import javamilos.com.example.demo.repository.CompanyRepository;
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
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
         this.companyRepository= companyRepository;
    }

    @GetMapping("/create")
    public String showSignUpForm(Company company) {
        return "add-company";
    }

    @PostMapping("/addcompany")
    public String addCompany(@Valid Company company, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-company";
        }
        companyRepository.save(company);
        model.addAttribute("companies", companyRepository.findAll());
        return "redirect:/index";
    }

    @GetMapping("/edit-company/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid company Id:" + id));
        model.addAttribute("company", company);
        return "update-company";
    }

    @PostMapping("/update-company/{id}")
    public String updateCompany(@PathVariable("id") long id, @Valid Company company, BindingResult result, Model model) {
        if (result.hasErrors()) {
            company.setId(id);
            return "update-company";
        }
        companyRepository.save(company);
        model.addAttribute("companies", companyRepository.findAll());
        return "redirect:/index-companies";
    }

    @GetMapping("/delete-company/{id}")
    public String deleteCompany(@PathVariable("id") long id, Model model) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid company Id:" + id));
        companyRepository.delete(company);
        model.addAttribute("companies", companyRepository.findAll());
        return "index";
    }

    @GetMapping("/index-companies")
    public String allCompanies(Model model){
        model.addAttribute("companies", companyRepository.findAll());
        return "index-companies";
    }
}
