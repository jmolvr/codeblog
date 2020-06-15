package com.spring.codeblog.service.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Optional<Post> findByIdOptional(final Long id){
        return codeBlogRepository.findById(id);
    }

    @Override
    public Post save(final Post post) {
        post.setData(LocalDate.now());
        return codeBlogRepository.save(post);
    }
    
}