package com.minishop.category.service;

import com.minishop.shared.entity.Category;
import com.minishop.shared.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // CREATE CATEGORY
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // GET ALL CATEGORIES
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // GET CATEGORY BY ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // UPDATE CATEGORY
    public Category updateCategory(Long id, Category category) {

        Category existingCategory =
                categoryRepository.findById(id).orElse(null);

        if (existingCategory == null) {
            return null;
        }

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        return categoryRepository.save(existingCategory);
    }

    // DELETE CATEGORY
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

        System.out.println("Category deleted successfully");
    }
}