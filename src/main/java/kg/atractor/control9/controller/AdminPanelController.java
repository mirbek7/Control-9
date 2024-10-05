package kg.atractor.control9.controller;

import kg.atractor.control9.model.Book;
import kg.atractor.control9.model.BookRequest;
import kg.atractor.control9.model.Category;
import kg.atractor.control9.model.User;
import kg.atractor.control9.service.BookRequestService;
import kg.atractor.control9.service.BookService;
import kg.atractor.control9.service.CategoryService;
import kg.atractor.control9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminPanelController {

    private final CategoryService categoryService;
    private final BookService bookService;
    private final UserService userService;
    private final BookRequestService bookRequestService;



    @GetMapping
    public String adminPanel() {
        return "admin-panel";
    }

    @GetMapping("/categories")
    public String manageCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin-categories";
    }

    @PostMapping("/categories/add")
    public String addCategory(@RequestParam("name") String name) {
        categoryService.addCategory(name);
        return "redirect:/admin/categories";
    }

    @PostMapping("/categories/delete")
    public String deleteCategory(@RequestParam("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories";
    }

    @GetMapping("/books")
    public String manageBooks(Model model) {
        List<Book> books = bookService.findAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("categories", categories);
        return "admin-books";
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("categoryId") Long categoryId) {
        bookService.addBook(title, author, categoryId);
        return "redirect:/admin/books";
    }

    @PostMapping("/books/delete")
    public String deleteBook(@RequestParam("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/admin/books";
    }

    @GetMapping("/users")
    public String manageUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin-users";
    }

    @GetMapping("/requests")
    public String manageRequests(Model model) {
        List<BookRequest> requests = bookRequestService.findAll();
        model.addAttribute("requests", requests);
        return "admin-requests";
    }

    @PostMapping("/requests/delete")
    public String deleteRequest(@RequestParam("requestId") Long requestId) {
        bookRequestService.deleteRequest(requestId);
        return "redirect:/admin/requests";
    }
}

