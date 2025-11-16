package com.example.spring_plsql_sample.article.controller;

import com.example.spring_plsql_sample.article.dto.ArticleCommandDto.ArticleUpdateCommand;
import com.example.spring_plsql_sample.article.dto.ArticleCommandDto.ArticleCreateCommand;
import com.example.spring_plsql_sample.article.dto.ArticleCommandDto.ArticleCommandResponse;
import com.example.spring_plsql_sample.article.mapper.ArticleDtoMapper;
import com.example.spring_plsql_sample.article.service.ArticleCommandService;
import com.example.spring_plsql_sample.article.service.ArticleQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleCommandApi {
    private final ArticleCommandService articleCommandService;
    private final ArticleQueryService articleQueryService;
    private final ArticleDtoMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleCommandResponse createArticle(
            @Valid @RequestBody ArticleCreateCommand request
    ) {
        var articleToCreate = mapper.toVo(request);
        var createdArticle = articleCommandService.createArticle(articleToCreate);
        return mapper.toCommandResponse(createdArticle);
    }

    @PutMapping("/{id}")
    public ArticleCommandResponse updateArticle(
            @PathVariable("id") Long id,
            @Valid @RequestBody ArticleUpdateCommand request
    ) {
        var existingArticle = articleQueryService.getArticleById(id);
        if (existingArticle == null) {
            throw new NoSuchElementException("Article not found with id: " + id);
        }

        mapper.updateVoFromDto(request, existingArticle);

        var updatedArticle = articleCommandService.updateArticle(existingArticle);
        return mapper.toCommandResponse(updatedArticle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable("id") Long id) {
        var existingArticle = articleQueryService.getArticleById(id);
        if (existingArticle == null) {
            throw new NoSuchElementException("Article not found with id: " + id);
        }

        articleCommandService.deleteArticle(id);
    }
}
