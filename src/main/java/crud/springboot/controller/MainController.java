package crud.springboot.controller;

import crud.springboot.model.Author;
import crud.springboot.model.Book;
import crud.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("books",bookRepository.findAll());
        model.addAttribute("book", Book.builder()
                .author(new Author())
                .build());
        return "index";
    }
}
