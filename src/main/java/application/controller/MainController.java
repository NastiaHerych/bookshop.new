package application.controller;

import application.models.User;
import application.repository.BookRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final BookRepository bookRepository;

    public MainController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/mainPage")
    public String goMain(@AuthenticationPrincipal User user,
                         Model model){
        model.addAttribute("username", user.getFirstName());
        model.addAttribute("books", bookRepository.findAll());
        return "mainPage";
    }

}
