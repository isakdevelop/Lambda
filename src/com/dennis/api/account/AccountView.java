package com.dennis.api.account;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) throws SQLException {
        while(AccountRouter.accountRouter(sc)) {
        }
    }
}
