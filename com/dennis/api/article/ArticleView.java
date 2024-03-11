package com.dennis.api.article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        ArticleController articleController = new ArticleController();
        while (true)    {
            System.out.print("[메뉴]\n" +
                    "0. 종료\n" +
                    "1. 기사 작성\n" +
                    "2. 기사 수정\n" +
                    "3. 기사 삭제\n" +
                    "4. 기사 검색\n" +
                    "5. 기사 목록\n" +
                    "입 력 : ");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;

                case "1":
                    System.out.println("=== 기사 작성 ===");
                    break;

                case "2":
                    System.out.println("=== 기사 수정 ===");
                    break;
                case "3":
                    System.out.println("=== 기사 삭제 ===");
                    break;
                case "4":
                    System.out.println("=== 기사 검색 ===");
                    break;
                case "5":
                    System.out.println("=== 기사 목록 ===");
                    articleController.articleService.findAll();
                    break;
            }
        }
    }
}
