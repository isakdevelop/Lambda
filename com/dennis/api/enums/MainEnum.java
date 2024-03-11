package com.dennis.api.enums;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public enum MainEnum {
    Exit("e", () -> {}),
    User("u", () -> {
        try {
            UserView.main(new Scanner(System.in));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Article("a", () -> {
        try {
            ArticleView.main(new Scanner(System.in));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    Board("b", () -> BoardView.main(new Scanner(System.in))),
    Crawler("c", () -> {
        try {
            CrawlerView.main(new Scanner(System.in));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),
    Account("m", () -> AccountView.main(new Scanner(System.in)));

    private final String commend;
    private final Runnable action;

    MainEnum(String commend, Runnable action) {
        this.commend = commend;
        this.action = action;
    }

    public static MainEnum getByCommend(String commend) {
        return Arrays.stream(values())
                .filter(o -> o.commend.equals(commend))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 입력."));
    }

    public void performAction() {
        action.run();
    }
}