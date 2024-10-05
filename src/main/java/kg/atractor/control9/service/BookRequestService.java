package kg.atractor.control9.service;

import kg.atractor.control9.model.BookRequest;

import java.time.LocalDate;
import java.util.List;

public interface BookRequestService {
    int countActiveRequestsForUser(Long id);

    void save(BookRequest bookRequest);

    List<BookRequest> findRequestsByUserAndDateRange(Long userId, LocalDate startDate, LocalDate endDate);

    void markAsReturned(Long requestId);

    void deleteRequest(Long requestId);

    List<BookRequest> findAll();
}
