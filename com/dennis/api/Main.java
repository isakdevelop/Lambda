package com.dennis.api;

import com.dennis.api.account.AccountView;
import com.dennis.api.article.ArticleView;
import com.dennis.api.board.BoardView;
import com.dennis.api.crawler.CrawlerView;
import com.dennis.api.enums.MainEnum;
import com.dennis.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("e - Exit \n" +
                    "u - User\n" +
                    "a - Article\n" +
                    "b - Board\n" +
                    "c - Crawler\n" +
                    "m - Account");

            System.out.println("input command : ");
            String input = sc.next();

            if (input.equals("e")) {
                break;
            }

            MainEnum command = MainEnum.getByCommend(input);
            command.performAction();
        }
    }
}