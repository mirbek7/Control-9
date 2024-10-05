package kg.atractor.control9.service.impl;

import kg.atractor.control9.model.BookRequest;
import kg.atractor.control9.model.ReturnStatus;
import kg.atractor.control9.repository.BookRequestRepository;
import kg.atractor.control9.service.BookRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRequestServiceImpl implements BookRequestService {

    private final BookRequestRepository bookRequestRepository;
    @Override
    public int countActiveRequestsForUser(Long userid) {
        return bookRequestRepository.countByUserIdAndReturnStatus(userid, ReturnStatus.EXPECTED);
    }

    @Override
    public void save(BookRequest bookRequest) {
        bookRequestRepository.save(bookRequest);
    }

    @Override
    public List<BookRequest> findRequestsByUserAndDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            return bookRequestRepository.findByUserIdAndReturnDateBetween(userId, startDate, endDate);
        } else {
            return bookRequestRepository.findByUserId(userId);
        }
    }

    @Override
    public void markAsReturned(Long requestId) {
        BookRequest request = bookRequestRepository.findById(requestId).orElseThrow(() -> new IllegalArgumentException("Неверный ID заявки"));
        request.setReturnStatus(ReturnStatus.RETURNED);
        request.getBook().setIsAvailable(true);
        bookRequestRepository.save(request);
    }
}
