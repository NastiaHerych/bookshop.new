package application.controller;

import application.models.User;
import application.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

//    @PostMapping("/login")
//    public String postLogin(User model) {
//        return "mainPage";
//    }
}
