package com.example.spring_plsql_sample.article.mapper;

import com.example.spring_plsql_sample.article.vo.ArticleVO;

import java.util.List;

public interface ArticleQueryRepository {

        List<ArticleVO> getAllArticles();

        ArticleVO getArticleById(Long id);
}
