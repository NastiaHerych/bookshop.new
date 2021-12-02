package application.controller;

import application.models.Book;
import application.repository.BookRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {

    private final BookRepository bookRepository;

    public AdminController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/adminPage")
    public String goRegister(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("message", "HERE");
        return "adminPage";
    }

    @PostMapping("/adminPage")
    public String postRegister(Book book){
        bookRepository.save(book);
        return "adminPage";
    }
}
