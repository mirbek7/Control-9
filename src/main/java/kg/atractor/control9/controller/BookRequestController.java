package kg.atractor.control9.controller;

import jakarta.validation.Valid;
import kg.atractor.control9.model.Book;
import kg.atractor.control9.model.BookRequest;
import kg.atractor.control9.model.ReturnStatus;
import kg.atractor.control9.model.User;
import kg.atractor.control9.service.BookRequestService;
import kg.atractor.control9.service.BookService;
import kg.atractor.control9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class BookRequestController {

    private final UserService userService;
    private final BookService bookService;
    private final BookRequestService bookRequestService;

    @GetMapping("/book-request")
    public String showBookRequestForm(@RequestParam("bookId") Long bookId, Model model) {
        Book book = bookService.findById(bookId);
        if (book == null) {
            model.addAttribute("error", "Книга не найдена.");
            return "error-page";
        }
        model.addAttribute("book", book);
        model.addAttribute("bookRequest", new BookRequest());
        return "books/book-request-form";
    }

    @PostMapping("/book-request")
    public String submitBookRequest(@Valid @ModelAttribute("bookRequest") BookRequest bookRequest,
                                    BindingResult result,
                                    @RequestParam("bookId") Long bookId,
                                    @RequestParam("libraryCardNumber") String libraryCardNumber,
                                    Model model) {

        if (result.hasErrors()) {
            model.addAttribute("book", bookService.findById(bookId));
            return "books/book-request-form";
        }

        User user = userService.findByLibraryCardNumber(libraryCardNumber);
        if (user == null) {
            model.addAttribute("error", "Неверный номер читательского билета");
            model.addAttribute("book", bookService.findById(bookId)); // чтобы сохранить данные книги при ошибке
            return "books/book-request-form";
        }

        if (bookRequestService.countActiveRequestsForUser(user.getId()) >= 3) {
            model.addAttribute("error", "Вы не можете взять более трёх книг одновременно");
            model.addAttribute("book", bookService.findById(bookId));
            return "books/book-request-form";
        }

        Book book = bookService.findById(bookId);
        if (book == null || !book.getIsAvailable()) {
            model.addAttribute("error", "Книга недоступна для получения");
            model.addAttribute("book", book);
            return "books/book-request-form";
        }

        bookRequest.setUser(user);
        bookRequest.setBook(book);
        bookRequest.setReturnDate(LocalDate.now().plusWeeks(2));
        bookRequest.setReturnStatus(ReturnStatus.EXPECTED);

        bookRequestService.save(bookRequest);

        book.setIsAvailable(false);
        bookService.save(book);

        return "redirect:/";
    }
}

