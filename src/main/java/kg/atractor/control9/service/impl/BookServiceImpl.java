package kg.atractor.control9.service.impl;

import kg.atractor.control9.errors.CategoryNotFoundException;
import kg.atractor.control9.model.Book;
import kg.atractor.control9.model.Category;
import kg.atractor.control9.repository.BookRepository;
import kg.atractor.control9.repository.CategoryRepository;
import kg.atractor.control9.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
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

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void addBook(String title, String author, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("No category found with id " + categoryId));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setIsAvailable(true);
        bookRepository.save(book);
    }

}
