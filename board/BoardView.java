package board;

import user.User;

import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void main(Scanner sc) {
        while (true)    {
            System.out.print("[메뉴]\n" +
                    "0. 종료\n" +
                    "1. 보드 이름 보기\n" +
                    "2. 보드 타입 보기\n" +
                    "입력 : ");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;

                case "1":
                    System.out.println("=== 보드 이름 보기 ===");
                    System.out.println();
                    break;

                case "2":
                    System.out.println("=== 보드 타입 보기 ===");
                    break;
            }
        }
    }
}
