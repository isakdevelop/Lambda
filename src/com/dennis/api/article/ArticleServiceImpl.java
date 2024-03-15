package com.dennis.api.article;

import com.dennis.api.common.AbstractService;
import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl implements com.dennis.api.article.ArticleService {
    private ArticleRepository articleRepository;
    private static ArticleService instance = new ArticleServiceImpl();

    public static com.dennis.api.article.ArticleService getInstance()  {
        return instance;
    }

    public ArticleServiceImpl() {
        articleRepository = ArticleRepository.getInstance();
    }


    @Override
    public Messenger createArticle(String subject, String content, String writer) throws SQLException {
        return articleRepository.createArticle(subject,content,writer);
    }

    @Override
    public Messenger modifyArticle(int id, String subject, String content) throws SQLException {
        return articleRepository.modifyArticle(id, subject, content);
    }

    @Override
    public Messenger deleteArticle(int id) throws SQLException {
        return articleRepository.deleteArticle(id);
    }

    @Override
    public Messenger searchArticleByTitle(String title) throws SQLException {
        return articleRepository.searchArticleByTitle(title);
    }

    @Override
    public Messenger searchArticleByContent(String str) throws SQLException {
        return articleRepository.searchArticleByContent(str);
    }

    @Override
    public Messenger searchArticleByWriter(String writer) throws SQLException {
        return articleRepository.searchArticleByWriter(writer);
    }
//
//
//    @Override
//    public Messenger save(Object o) {
//        return null;
//    }
//
    @Override
    public Messenger findAll() throws SQLException {
        return articleRepository.findAll();
    }

//    @Override
//    public Optional findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Long count() {
//        return null;
//    }
//
//    @Override
//    public Optional getOne(String id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Messenger delete(Object o) {
//        return null;
//    }
//
//    @Override
//    public String deleteAll() {
//        return null;
//    }
//
//    @Override
//    public Boolean existsById(Long id) {
//        return null;
//    }
}
