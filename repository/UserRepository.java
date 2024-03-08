package repository;

import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    private static final UserRepository instance;
    private final Connection connection;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRepository getInstance(){return instance;}

    private UserRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot"
        );
    }

    public String test()    {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        PreparedStatement pdst = connection.prepareStatement(sql);
        ResultSet resultSet = pdst.executeQuery();
        if(resultSet.next()){
            do{
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("writer"));
                System.out.println();
            }while(resultSet.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }

        resultSet.close();
        pdst.close();
        connection.close();

        return null;
    }

    public String createUserTable() throws SQLException {
        String sql="CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY" +
                ",username VARCHAR(50),password VARCHAR(50),name VARCHAR(100)" +
                ",phone VARCHAR(20),job VARCHAR(50),height VARCHAR(10)" +
                ",weight VARCHAR(10))";


            connection.prepareStatement(sql).executeUpdate();
            return "테이블이 이미 존재하여 회원 테이블 생성하지 않음";

    }

    public String insertUser(User user) throws SQLException {
        String sql = "insert into users(username, password, name" +
                ", phone, job, height, weight) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pdst = connection.prepareStatement(sql);

        pdst.setString(1, user.getUserName());
        pdst.setString(2, user.getPassword());
        pdst.setString(3, user.getName());
        pdst.setString(4, user.getPhone());
        pdst.setString(5, user.getJob());
        pdst.setDouble(6, user.getHeight());
        pdst.setDouble(7, user.getWeight());

        int result = pdst.executeUpdate();

        if (result > 0) {
            return "회원 튜플 생성 완료";
        } else {
            return "회원 튜플 생성 실패";
        }
    }

    public String databaseLogin(String username, String password) throws SQLException {
        String sql = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, username);
        pdst.setString(2, password);

        ResultSet rs = pdst.executeQuery();
        if (rs.next()) {
            return "로그인 성공";
        } else {
            return "로그인 실패";
        }

    }

//    public String findUserDatabaseById(String username) throws SQLException {
//        String sql = "SELECT * FROM users WHERE username = ?";
//        PreparedStatement pdst = connection.prepareStatement(sql);
//        pdst.setString(1, username);
//
//        ResultSet rs = pdst.executeQuery();
//        if (rs.next()) {
//            do{
//                System.out.println();
//            }
//        }
//
//    }
}


/*
String sql = "select * from board";
        PreparedStatement pdst = connection.prepareStatement(sql);
        ResultSet resultSet = pdst.executeQuery();
        if(resultSet.next()){
            do{
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("writer"));
                System.out.println();
            }while(resultSet.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }

        resultSet.close();
        pdst.close();
        connection.close();

        return null;
 */