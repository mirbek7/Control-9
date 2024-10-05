package kg.atractor.control9.controller;

import kg.atractor.control9.model.BookRequest;
import kg.atractor.control9.model.User;
import kg.atractor.control9.service.BookRequestService;
import kg.atractor.control9.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {

    private final UserService userService;
    private final BookRequestService bookRequestService;

    public ProfileController(UserService userService, BookRequestService bookRequestService) {
        this.userService = userService;
        this.bookRequestService = bookRequestService;
    }

    @GetMapping("/profile")
    public String showProfile(Model model, @RequestParam("userId") Long userId,
                              @RequestParam(value = "startDate", required = false) String startDateStr,
                              @RequestParam(value = "endDate", required = false) String endDateStr) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);

        LocalDate startDate = (startDateStr != null) ? LocalDate.parse(startDateStr) : null;
        LocalDate endDate = (endDateStr != null) ? LocalDate.parse(endDateStr) : null;

        List<BookRequest> bookRequests = bookRequestService.findRequestsByUserAndDateRange(userId, startDate, endDate);
        model.addAttribute("bookRequests", bookRequests);

        return "auth/profile";
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestParam("requestId") Long requestId, @RequestParam("userId") Long userId) {
        bookRequestService.markAsReturned(requestId);
        return "redirect:/profile?userId=" + userId;
    }
}
