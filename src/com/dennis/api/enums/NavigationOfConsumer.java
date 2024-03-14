package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public enum NavigationOfConsumer {
    Exit("exit", i -> System.exit(0)),
    User("user", i ->
    {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Article("article", i ->
    {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Board("board", BoardView::main),
    Crawler("crawler", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    Account("account", AccountView::main),
    InputError("input_error", i -> {})
    ;

    private final String command;
    private final Consumer<Scanner> consumer;

    NavigationOfConsumer(String command, Consumer<Scanner> consumer) {
        this.command = command;
        this.consumer = consumer;
    }

    public static void select_consumer(Scanner sc) {
        System.out.println("exit - Exit \n" +
                "user - User\n" +
                "article - Article\n" +
                "board - Board\n" +
                "crawler - Crawler\n" +
                "account - Account");
        System.out.print("input command : ");
        String input = sc.next();
        Stream.of(values()).filter(i -> i.command.equals(input))
                .findAny().orElse(InputError).consumer.accept(sc);
    }
}
