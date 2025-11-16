package com.example.spring_plsql_sample.article.persistence;

import com.example.spring_plsql_sample.article.mapper.ArticleCommandRepository;
import com.example.spring_plsql_sample.article.mapper.ArticleQueryRepository;
import com.example.spring_plsql_sample.article.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MyBatisArticleRepository implements ArticleCommandRepository, ArticleQueryRepository {

    private final MyBatisArticleMapper boardMapper;

    @Override
    public ArticleVO createArticle(ArticleVO articleVO) {
        boardMapper.createArticle(articleVO);
        return articleVO;
    }

    @Override
    public List<ArticleVO> getAllArticles() {
        Map<String, Object> param = new HashMap<>();
        boardMapper.getAllArticles(param);

        List<ArticleVO> articleList = (List<ArticleVO>) param.get("cursor");
        return articleList != null ? articleList : List.of();
    }

    @Override
    public ArticleVO getArticleById(Long id) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        boardMapper.getArticleById(param);

        List<ArticleVO> articleList = (List<ArticleVO>) param.get("cursor");
        if (articleList != null && !articleList.isEmpty()) {
            return articleList.get(0);
        }
        return null;
    }

    @Override
    public ArticleVO updateArticle(ArticleVO articleVO) {
        boardMapper.updateArticle(articleVO);
        return articleVO;
    }

    @Override
    public void deleteArticle(Long id) {
        boardMapper.deleteArticle(id);
    }
}