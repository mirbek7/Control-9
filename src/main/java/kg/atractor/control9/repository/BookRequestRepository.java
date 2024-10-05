package kg.atractor.control9.repository;

import kg.atractor.control9.model.BookRequest;
import kg.atractor.control9.model.ReturnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest,Long> {
    int countByUserIdAndReturnStatus(Long userid, ReturnStatus returnStatus);

    List<BookRequest> findByUserIdAndReturnDateBetween(Long userId, LocalDate startDate, LocalDate endDate);

    List<BookRequest> findByUserId(Long userId);
}
