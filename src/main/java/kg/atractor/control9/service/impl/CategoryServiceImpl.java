package kg.atractor.control9.service.impl;

import kg.atractor.control9.model.Category;
import kg.atractor.control9.repository.CategoryRepository;
import kg.atractor.control9.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
