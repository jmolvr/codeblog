package com.spring.codeblog;

import java.time.LocalDate;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeblogService;
import com.spring.codeblog.service.ServiceImpl.CodeblogServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalAnswers.returnsFirstArg;


class CodeBlogTestPost{

    private CodeBlogRepository codeBlogRepository = Mockito.mock(CodeBlogRepository.class);
    private CodeblogService codeblogService;

    @BeforeEach
    void initPostCase() {
        codeblogService = new CodeblogServiceImpl(codeBlogRepository);
    }


    @Test
    void savedPostHasDate(){
        Post post = new Post(Long.valueOf(1), "Teste", "Testador", LocalDate.now(), "Testando com JUnit");
        when(codeBlogRepository.save(any(Post.class))).then(returnsFirstArg());
        Post postSaved = codeblogService.save(post);
        assertThat(postSaved.getTexto()).isEqualTo("Testando com JUnit");
    }

    
        
}