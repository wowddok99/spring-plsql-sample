package com.example.spring_plsql_sample.article.controller;

import com.example.spring_plsql_sample.article.service.ArticleQueryService;
import com.example.spring_plsql_sample.article.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleQueryApi {
    private final ArticleQueryService articleQueryService;

    @GetMapping
    public List<ArticleVO> getAllArticles() {
        return articleQueryService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleVO getArticleById(@PathVariable("id") Long id) {
        var existingArticle = articleQueryService.getArticleById(id);
        if (existingArticle == null) {
            throw new NoSuchElementException("Article not found with id: " + id);
        }
        return existingArticle;
    }
}
