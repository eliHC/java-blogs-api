package com.example.javaivp1.services;


import com.example.javaivp1.models.BlogPost;
import com.example.javaivp1.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogPost {

    @Autowired
    private PostRepo repo;


    @Override
    public List<BlogPost> getAll() {
        return repo.getAll();
    }


    @Override
    public Optional<BlogPost> getById(int id) {
      return repo.getById(id);
    }
}
