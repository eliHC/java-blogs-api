package com.example.javaivp1.repository;

import com.example.javaivp1.models.BlogPost;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepo {
    private final String linkFile = "src/main/resources/posts.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<BlogPost> getAll() {
        List<BlogPost> posts = null;

        try {
            posts = Arrays.asList(mapper.readValue(new File(linkFile), BlogPost[].class));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return posts;
    }

    public Optional<BlogPost> getById(String id) {
        List<BlogPost> posts = null;

        try {
            posts = Arrays.asList(mapper.readValue(new File(linkFile), BlogPost[].class));
            int convertedId = Integer.parseInt(id);

            for (BlogPost blogpost : posts) {
                if (blogpost.getId() == convertedId) {
                    return Optional.of(blogpost);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }

    public void addPost(BlogPost newBlogPost) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<BlogPost> blogposts = this.getAll();

        blogposts = new ArrayList<>(blogposts);

        blogposts.add(newBlogPost);

        try {
            writer.writeValue(new File(linkFile), blogposts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
