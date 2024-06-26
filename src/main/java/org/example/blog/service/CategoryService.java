package org.example.blog.service;

import org.example.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category el);

    void delete(int id);

    long count();
}
