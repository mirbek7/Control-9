package kg.atractor.control9.service;

import kg.atractor.control9.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book findById(Long bookId);

    void save(Book book);

    List<Book> findAll();
}
