package org.example.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.example.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    Blog save(Blog obj);

   void remove(int id);

   long count();

   // findAll() paging
    Page<Blog> findAll(Pageable pageable);

    // find by title
    Page<Blog> findByTitle(Pageable pageable, String text);
}
