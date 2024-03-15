package com.dennis.api.article;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface ArticleService {
    Messenger createArticle(String subject, String content, String writer) throws SQLException;
    Messenger modifyArticle(int id, String subject, String content) throws SQLException;
    Messenger deleteArticle(int id) throws SQLException;
    Messenger searchArticleByTitle(String title) throws SQLException;
    Messenger searchArticleByContent(String str) throws SQLException;
    Messenger searchArticleByWriter(String writer) throws SQLException;
    Messenger findAll() throws SQLException;
}
