package org.example.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogsByTitleContaining(Pageable pageable, String text);
}
