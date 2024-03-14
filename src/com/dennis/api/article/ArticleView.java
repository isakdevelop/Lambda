package com.dennis.api.article;

import java.sql.SQLException;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner sc) throws SQLException {
        while (ArticleRouter.articleRouter(sc))    {
        }
    }
}
