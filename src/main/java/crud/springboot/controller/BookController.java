package crud.springboot.controller;

import crud.springboot.model.Book;
import crud.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public String add(Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String book(@PathVariable("id")int id, Model model){
        model.addAttribute("book",bookRepository.findById(id).get());
        model.addAttribute("books",bookRepository.findAll());
        return "index";
    }

    @PostMapping("/update")
    public String update(Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }
}
