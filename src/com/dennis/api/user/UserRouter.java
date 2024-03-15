package com.dennis.api.user;

import com.dennis.api.menu.MenuController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public enum UserRouter {
    EXIT("0", sc -> false),
    SIGNUP("1", sc -> {
        try {
            System.out.println(UserController.getInstance().insertUser(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    LOGIN("2", sc -> {
        try {
            System.out.println(UserController.getInstance().databaseLogin(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    SELECTID("3", sc -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabaseById(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    PASSWORDCHANGE("4", sc -> {
        try {
            System.out.println(UserController.getInstance().changeDatabasePassword(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    WITHDRAWAL("5", sc -> {
        try {
            System.out.println(UserController.getInstance().changeDatabasePassword(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FINDUSER("6", sc -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabase());
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FINDUSERBYNAME("7", sc -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabaseByName(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FINDUSERBYJOB("8", sc -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabaseByJob(sc));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    USERCOUNT("9", sc -> {
        try {
            System.out.println(UserController.getInstance().userCount());
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    WRONG("?", sc -> true)
    ;
    private final String command;
    private final Predicate<Scanner> predicate;

    UserRouter(String command, Predicate<Scanner> predicate) {
        this.command = command;
        this.predicate = predicate;
    }

    public static boolean userRoute(Scanner sc) throws SQLException {
        List<String> ls = MenuController.getInstance().getMenuList("user");
        ls.forEach(i -> System.out.println(i));
        String input = sc.next();
        return Arrays.stream(values())
                .filter(i -> i.command.equals(input))
                .findAny().orElse(WRONG)
                .predicate.test(sc);
    }
}
