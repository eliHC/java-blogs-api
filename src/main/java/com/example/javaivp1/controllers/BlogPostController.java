package com.example.javaivp1.controllers;

import com.example.javaivp1.models.BlogPost;
import com.example.javaivp1.services.IBlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private IBlogPost service;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}