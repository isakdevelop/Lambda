package com.dennis.api.article;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleController{
    private static ArticleController instance = new ArticleController();
    public static ArticleController getInstance() {
        return instance;
    }
    ArticleService articleService = ArticleServiceImpl.getInstance();
    public Messenger createArticle(Scanner sc) throws SQLException {
        System.out.println("작성하실 기사의 제목, 내용, 작성자를 차례대로 입력해주세요.");
        return articleService.createArticle(sc.next(), sc.next(), sc.next());
    }

    public Messenger modifyArticle(Scanner sc) throws SQLException {
        System.out.println("수정 할 글의 아이디 입력");
        int id = sc.nextInt();
        System.out.print("수정 후 글의 제목 : ");
        String title = sc.next();
        System.out.print("수정 후 글의 내용 : ");
        String content = sc.next();
        return articleService.modifyArticle(id,title,content);
    }

    public Messenger deleteArticle(Scanner sc) throws SQLException {
        System.out.println("수정 할 글의 아이디 입력 : ");
        return articleService.deleteArticle(sc.nextInt());
    }

    public Messenger searchArticleByTitle(Scanner sc) throws SQLException {
        System.out.print("포함되는지 찾아볼 제목 : ");
        return articleService.searchArticleByTitle(sc.next());
    }

    public Messenger searchArticleByContent(Scanner sc) throws SQLException {
        System.out.print("포함되는지 찾아볼 내용 : ");
        return articleService.searchArticleByContent(sc.next());
    }

    public Messenger searchArticleByWriter(Scanner sc) throws SQLException {
        System.out.print("포함되는지 찾아볼 글쓴이 : ");
        return articleService.searchArticleByWriter(sc.next());
    }

    public Messenger findAll() throws SQLException {
        return articleService.findAll();
    }
}
