package com.leal.store.services;

import com.leal.store.entities.Category;
import com.leal.store.repositores.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category finById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}
