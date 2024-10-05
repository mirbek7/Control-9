package kg.atractor.control9.controller;

import kg.atractor.control9.model.Book;
import kg.atractor.control9.repository.BookRepository;
import kg.atractor.control9.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;
    @GetMapping("/")
    public String showBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String search,
            Model model) {

        Page<Book> books  = bookRepository.findByTitleContaining(search, PageRequest.of(page, 5));
        model.addAttribute("books", books.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", books.getTotalPages());
        model.addAttribute("search", search);

        return "books/book-list";
    }

    @GetMapping("/book")
    public String showBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books/book";
    }


}
