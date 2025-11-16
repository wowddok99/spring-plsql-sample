package com.example.spring_plsql_sample.article.persistence;

import com.example.spring_plsql_sample.article.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MyBatisArticleMapper {

    void createArticle(ArticleVO articleVO);

    void getAllArticles(Map<String, Object> param);

    void getArticleById(Map<String, Object> param);

    void updateArticle(ArticleVO articleVO);

    void deleteArticle(Long id);
}