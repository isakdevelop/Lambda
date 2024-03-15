package com.dennis.api.board;

import java.sql.SQLException;
import java.util.Scanner;

public class BoardView {
    public static void main(Scanner sc) throws SQLException {
        while (BoardRouter.boardRouter(sc))    {
        }
    }
}
