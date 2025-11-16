package com.example.spring_plsql_sample.article.service;

import com.example.spring_plsql_sample.article.mapper.ArticleQueryRepository;
import com.example.spring_plsql_sample.article.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleQueryService {

    private final ArticleQueryRepository articleQueryRepository;

    public List<ArticleVO> getAllArticles() {
        return articleQueryRepository.getAllArticles();
    }

    public ArticleVO getArticleById(Long id) {
        return articleQueryRepository.getArticleById(id);
    }
}