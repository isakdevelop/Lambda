package com.dennis.api.user;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public enum UserViewEnum {
    EXIT("e", scanner -> false),
    SIGNUP("signup", scanner -> {
        try {
            System.out.println(UserController.getInstance().insertUser(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    LOGIN("login", scanner -> {
        try {
            System.out.println(UserController.getInstance().databaseLogin(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    SELECTID("selectId", scanner -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabaseById(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    PASSWORDCHANGE("passwordChange", scanner -> {
        try {
            System.out.println(UserController.getInstance().changeDatabasePassword(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    WITHDRAWAL("withdrawal", scanner -> {
        try {
            System.out.println(UserController.getInstance().changeDatabasePassword(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FINDUSER("finduser", scanner -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabase());
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FINDUSERBYNAME("finduserbyname", scanner -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabaseByName(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    FINDUSERBYJOB("finduserbyjob", scanner -> {
        try {
            System.out.println(UserController.getInstance().findUserDatabaseByJob(scanner));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    USERCOUNT("usercount", scanner -> {
        try {
            System.out.println(UserController.getInstance().userCount());
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    })
    ;
    private final String command;
    private final Predicate<Scanner> action;

    UserViewEnum(String command, Predicate<Scanner> action) {
        this.command = command;
        this.action = action;
    }

    public boolean performAction(Scanner sc) {
        return action.test(sc);
    }

    public static UserViewEnum getByCommand(String command) {
        return Arrays.stream(values())
                .filter(o -> o.command.equals(command))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid command."));
    }
}
