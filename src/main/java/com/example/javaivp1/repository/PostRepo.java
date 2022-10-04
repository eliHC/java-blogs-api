package com.example.javaivp1.repository;

import com.example.javaivp1.models.BlogPost;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepo {
    private final String linkFile = "src/main/resources/posts.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<BlogPost> getAll() {
        List<BlogPost> posts = null;

        try {
            posts = Arrays.asList(mapper.readValue(new File(linkFile), BlogPost[].class));

        } catch (Exception ex) {
            System.out.println("quebrou");
        }

        return posts;
    }
}
