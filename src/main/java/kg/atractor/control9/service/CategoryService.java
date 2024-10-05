package kg.atractor.control9.service;

import kg.atractor.control9.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void addCategory(String name);

    void deleteCategory(Long categoryId);
}
