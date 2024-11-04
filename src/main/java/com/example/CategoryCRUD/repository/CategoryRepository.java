package com.example.CategoryCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CategoryCRUD.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
