package application.controller;

import application.models.Role;
import application.models.User;
import application.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String postRegister(User model , User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "redirect:/register?error";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        userRepository.save(user);
        return "register_success";
    }
}
