package kg.atractor.control9.errors;

import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;
@RequiredArgsConstructor
public class CategoryNotFoundException extends NoSuchElementException {
    public CategoryNotFoundException(String s) {
    }
}
