package com.dennis.api.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController{
    ArticleService articleService = ArticleServiceImpl.getInstance();
    public String writeArticle(Scanner sc) {
        System.out.println("작성하실 기사의 제목, 내용, 작성자를 차례대로 입력해주세요.");
        return articleService.writeArticle(sc.next(), sc.next(), sc.next());
    }

    public String modifyArticle(int id, String subject, String content) {
        return null;
    }

    public String deleteArticle(int id) {
        return null;
    }

    public List<?> searchArticleByTitle(String title) {
        return null;
    }

    public List<?> searchArticleByContent(String str) {
        return null;
    }

    public List<?> searchArticleByWriter(String writer) {
        return null;
    }

    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
