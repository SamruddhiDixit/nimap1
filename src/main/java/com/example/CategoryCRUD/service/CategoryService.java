package com.example.CategoryCRUD.service;


import com.example.CategoryCRUD.model.Category;
import com.example.CategoryCRUD.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

	
	
	

	    @Autowired
	    private CategoryRepository categoryRepository;

	    // Get all categories with pagination
	    public Page<Category> getAllCategories(int page, int size) {
	        return categoryRepository.findAll(PageRequest.of(page, size));
	    }

	    // Get a category by ID
	    public Optional<Category> getCategoryById(Long id) {
	        return categoryRepository.findById(id);
	    }

	    // Create a new category
	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    // Update a category by ID
	    public Category updateCategory(Long id, Category categoryDetails) {
	        Category category = categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	        category.setName(categoryDetails.getName());
	        category.setDescription(categoryDetails.getDescription());
	        return categoryRepository.save(category);
	    }

	    // Delete a category by ID
	    public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
	
}
