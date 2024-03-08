import account.AccountView;
import article.ArticleView;
import board.BoardView;
import crawler.CrawlerView;
import user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (true)    {
            System.out.println("e - Exit \n" +
                    "u - User\n" +
                    "a - Article\n" +
                    "b - Board\n" +
                    "c - Crawler\n" +
                    "m - Account");

            switch (sc.next())   {
                case "0":
                    return;
                case "a":
                    AccountView.main(sc);
                    break;
                case "b":
                    BoardView.main(sc);
                    break;
                case "c":
                    CrawlerView.main(sc);
                    break;
                case "m":
                    ArticleView.main(sc);
                    break;
                case "u":
                    UserView.main(sc);
                    break;
            }
        }
    }
}