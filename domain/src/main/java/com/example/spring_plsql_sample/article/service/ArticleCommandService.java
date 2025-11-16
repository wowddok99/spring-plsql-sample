package com.example.spring_plsql_sample.article.service;

import com.example.spring_plsql_sample.article.mapper.ArticleCommandRepository;
import com.example.spring_plsql_sample.article.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleCommandService {

    private final ArticleCommandRepository articleCommandRepository;

    @Transactional
    public ArticleVO createArticle(ArticleVO articleVO) {
        return articleCommandRepository.createArticle(articleVO);
    }

    @Transactional
    public ArticleVO updateArticle(ArticleVO articleVO) {
        return articleCommandRepository.updateArticle(articleVO);

    }

    @Transactional
    public void deleteArticle(Long id) {
        articleCommandRepository.deleteArticle(id);
    }
}