package com.example.javaivp1.services;

import com.example.javaivp1.models.BlogPost;

import java.util.List;
import java.util.Optional;

public interface IBlogPost {
    List<BlogPost> getAll();

    Optional<BlogPost> getById(String id);
}
