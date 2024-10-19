package com.retailStore.retailStore.service;

import com.retailStore.retailStore.model.Category;
import com.retailStore.retailStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Method to retrieve all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Method to retrieve a single category by ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Method to add a new category
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Method to update an existing category
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setCategoryName(categoryDetails.getCategoryName());
        // Update other fields as needed

        return categoryRepository.save(category);
    }

    // Method to delete a category by ID
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
