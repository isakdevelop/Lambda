import account.AccountView;
import board.BoardView;
import crawler.CrawlerView;
import user.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true)    {
            System.out.println("0. 종료 , 1. 사용자 정보, 2. 게시판, 3. 결제 정보, 4. 크롤러");

            switch (sc.next())   {
                case "0":
                    return;
                case "1":
                    UserView.main(sc);
                    break;
                case "2":
                    BoardView.main();
                    break;
                case "3":
                    AccountView.main(sc);
                    break;
                case "4":
                    CrawlerView.main(sc);
            }
        }
    }
}