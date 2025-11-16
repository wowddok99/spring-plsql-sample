package com.example.spring_plsql_sample.article.mapper;

import com.example.spring_plsql_sample.article.vo.ArticleVO;

public interface ArticleCommandRepository {

        ArticleVO createArticle(ArticleVO articleVO);

        ArticleVO updateArticle(ArticleVO articleVO);

        void deleteArticle(Long id);
}
