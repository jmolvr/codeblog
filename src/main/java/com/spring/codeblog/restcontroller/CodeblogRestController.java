package com.spring.codeblog.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rest")
public class CodeblogRestController {
    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getPosts(){
        return codeblogService.findAll();
    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> GetPostById(@PathVariable(value = "id") final Long id){
        Optional<Post> post = codeblogService.findByIdOptional(id);
        if(post.isPresent()){
            return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public Post postSave(@Valid @RequestBody Post post){
        return codeblogService.save(post);
    }
}