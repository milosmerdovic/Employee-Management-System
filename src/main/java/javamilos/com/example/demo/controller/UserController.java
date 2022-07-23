package javamilos.com.example.demo.controller;

import javamilos.com.example.demo.entity.User;
import javamilos.com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/user")
    public String showUserForm(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/user";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/user/index";
    }

    @GetMapping("/user/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "/user/update-user";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "/user/update-user";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "/user/index";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "/user/index";
    }

    @GetMapping("/user/index")
    public String getAllUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "/user/index";
    }

}
