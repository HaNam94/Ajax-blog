package org.example.blog.service;

import org.example.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog obj);

   void remove(int id);
}
