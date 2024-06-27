package org.example.blog.repository;

import org.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
