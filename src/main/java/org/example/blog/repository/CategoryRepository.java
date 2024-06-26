package org.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
