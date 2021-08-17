package application.controller;

import application.models.User;
import application.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/welcome")
    public String goIndex() {
        return "welcome";
    }

    @GetMapping("/register")
    public String goRegister(Model model){
        model.addAttribute("register", new User());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(User model){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(model.getPassword());
        model.setPassword(encodedPassword);
        userRepository.save(model);
        return "register_success";
    }

}
