package com.dennis.api.repository;

import com.dennis.api.enums.Messenger;
import com.dennis.api.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    private static final UserRepository instance;
    private final Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRepository getInstance() {
        return instance;
    }

    private UserRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot"
        );
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
                System.out.println();
            } while (rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public Messenger createUserTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY" +
                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
                ",weight VARCHAR(10))";


        int ex = connection.prepareStatement(sql).executeUpdate();

        // return (ex == 0) ? "SUCCES" : "FAIL";
            return null;
    }

//    public String createUserTable() throws SQLException {
//        String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY" +
//                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
//                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
//                ",weight VARCHAR(10))";
//
//
//        connection.prepareStatement(sql).executeUpdate();
//        return "테이블이 이미 존재하여 회원 테이블 생성하지 않음";
//
//    }

    public String insertUser(User user) throws SQLException {
        String sql = "insert into users(username, password, name" +
                ", phone, job, height, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.setDouble(6, user.getHeight());
        pstmt.setDouble(7, user.getWeight());

        int result = pstmt.executeUpdate();

        if (result > 0) {
            return "회원 튜플 생성 완료";
        } else {
            return "회원 튜플 생성 실패";
        }
    }

    public String databaseLogin(String username, String password) throws SQLException {
        String sql = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        rs = pstmt.executeQuery();
        if (rs.next()) {
            return "로그인 성공";
        } else {
            return "로그인 실패";
        }

    }

//    public String databaseDelete() throws SQLException {
//        String sql = "DROP TABLE users";
//        // String sql = "Delete from users"; user의 모든 레코드 삭제
//        pstmt = connection.prepareStatement(sql);
//    }
}