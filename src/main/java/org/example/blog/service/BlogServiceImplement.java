package org.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.blog.model.Blog;
import org.example.blog.repository.BlogRepository;
import java.util.List;

@Service
public class BlogServiceImplement implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog obj) {
        blogRepository.save(obj);
        return obj;
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public long count() {
        return blogRepository.count();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByTitle(Pageable pageable, String text) {
        return blogRepository.findBlogsByTitleContaining(pageable, text);
    }
}
