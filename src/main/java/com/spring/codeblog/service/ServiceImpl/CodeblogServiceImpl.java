package com.spring.codeblog.service.ServiceImpl;

import java.util.List;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeblogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeblogServiceImpl implements CodeblogService {
    
    @Autowired
    CodeBlogRepository codeBlogRepository;

    @Override
    public List<Post> findAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepository.save(post);
    }
    
}