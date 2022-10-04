package com.example.javaivp1.controllers;

import com.example.javaivp1.models.BlogPost;
import com.example.javaivp1.services.IBlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class BlogPostController {

    @Autowired
    private IBlogPost service;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BlogPost>> getById(@PathVariable String id) {
        Optional<BlogPost> blogpost = service.getById(id);

        return new ResponseEntity<>(blogpost, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody BlogPost blogPost) {
        service.create(blogPost);
    }
}
