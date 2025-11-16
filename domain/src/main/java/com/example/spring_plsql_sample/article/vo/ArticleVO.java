package com.example.spring_plsql_sample.article.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Instant createdAt;
    private Instant updatedAt;
}