package com.spring.codeblog.service;

import java.util.List;
import java.util.Optional;

import com.spring.codeblog.model.Post;

public interface CodeblogService {
    List<Post> findAll();
    Post findById(Long id);
    Optional<Post> findByIdOptional(Long id);
    Post save(Post post);
}