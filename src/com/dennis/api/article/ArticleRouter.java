package com.dennis.api.article;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {
    EXIT("0", i -> false),
    CREATE("1", i -> {
        try {
            ArticleController.getInstance().createArticle(i);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Modify("2", i -> {
        try {
            ArticleController.getInstance().modifyArticle(i);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Delete("3", i -> {
        try {
            ArticleController.getInstance().deleteArticle(i);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    SelectByTitle("4", i -> {
        try {
            ArticleController.getInstance().searchArticleByTitle(i);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    SelectByContent("5", i -> {
        try {
            ArticleController.getInstance().searchArticleByContent(i);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    SelectByWriter("6", i -> {
        try {
            ArticleController.getInstance().searchArticleByWriter(i);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FindAll("7", i -> {
        try {
            ArticleController.getInstance().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Wrong("?", i -> true)
    ;
    private final String command;
    private final Predicate<Scanner> predicate;

    ArticleRouter(String command, Predicate<Scanner> predicate) {
        this.command = command;
        this.predicate = predicate;
    }

    public static boolean articleRouter(Scanner sc) {
        System.out.print("[ MENU ]\n" +
                "0. Exit\n" +
                "1. Write_Article\n" +
                "2. Modify_Article\n" +
                "3. Delete_Article\n" +
                "4. Select_Article_By_Title\n" +
                "5. Select_Article_By_Content\n" +
                "6. Select_Article_By_Writer\n" +
                "7. Select_All\n" +
                "input command : ");
        String input = sc.next();
        return Stream.of(values())
                .filter(i -> i.command.equals(input))
                .findAny().orElse(Wrong)
                .predicate.test(sc);
    }
}
