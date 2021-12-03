package application.controller;

import application.models.Book;
import application.models.User;
import application.repository.BookRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {

    private final BookRepository bookRepository;

    private final UserRepository userRepository;

    public AdminController(BookRepository bookRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/adminPage")
    public String goRegister(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("message", "HERE");
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "adminPage";
    }

    @PostMapping("/adminPage")
    public String postRegister(Book book){
        bookRepository.save(book);
        return "adminPage";
    }


}
