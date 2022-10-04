package com.example.javaivp1.models;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    private int id;
    private String postTitle;
    private String authorName;
    private Date postDate;

}
