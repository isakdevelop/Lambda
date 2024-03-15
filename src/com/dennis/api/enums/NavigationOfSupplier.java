package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum NavigationOfSupplier {
    EXIT("exit", () -> String.valueOf(Messenger.FAIL)),
    USER("user", () ->
    {
        try {
            UserView.main(new Scanner(System.in));
            return String.valueOf(Messenger.SUCCESS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    ARTICLE("article", () ->
    {
        try {
            ArticleView.main(new Scanner(System.in));
            return String.valueOf(Messenger.SUCCESS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    BOARD("board", () -> {
        try {
            BoardView.main(new Scanner(System.in));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(Messenger.SUCCESS);
    }),
    CRAWLER("crawler", () -> {
        try {
            CrawlerView.main(new Scanner(System.in));
            return String.valueOf(Messenger.SUCCESS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    ACCOUNT("account", () -> {
        try {
            AccountView.main(new Scanner(System.in));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(Messenger.SUCCESS);
    }),
    INPUT_ERROR("?", () -> String.valueOf(Messenger.FAIL));

    private final String command;
    private final Supplier<String> supplier;

    NavigationOfSupplier(String command, Supplier<String> supplier) {
        this.command = command;
        this.supplier = supplier;
    }

    public static String selectSupplier(Scanner sc) {
        System.out.println("exit - Exit \n" +
                "user - User\n" +
                "article - Article\n" +
                "board - Board\n" +
                "crawler - Crawler\n" +
                "account - Account");
        System.out.print("input command : ");
        String input = sc.next();
        return Stream.of(values()).filter(i -> i.command.equals(input))
                .findAny().orElse(INPUT_ERROR).supplier.get();
    }
}
