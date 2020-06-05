package com.spring.codeblog.service.ServiceImpl;

import java.util.List;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeblogService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeblogServiceImpl implements CodeblogService {
    
    private final CodeBlogRepository codeBlogRepository;

    @Override
    public List<Post> findAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(final Long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public Post save(final Post post) {
        return codeBlogRepository.save(post);
    }
    
}