package kg.atractor.control9.service.impl;

import kg.atractor.control9.model.Book;
import kg.atractor.control9.repository.BookRepository;
import kg.atractor.control9.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long bookId) {
        bookRepository.findById(bookId);
        return new Book();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
