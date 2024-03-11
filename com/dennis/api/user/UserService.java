package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface UserService {
    String addUsers();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();
    List<?> findUsersByUserName(String userName);
    String test();
    List<?> findUsers() throws SQLException;
    String insertUser(User user) throws SQLException;

    Messenger createUserTable() throws SQLException;

    String databaseLogin(String username, String password) throws SQLException;
}