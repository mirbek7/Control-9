package kg.atractor.control9.repository;

import kg.atractor.control9.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book>findByTitleContaining(String title, Pageable pageable);
}
