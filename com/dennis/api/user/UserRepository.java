package com.dennis.api.user;

import com.dennis.api.enums.Messenger;

import java.sql.*;
import java.util.List;

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

    public Messenger insertUser(User user) throws SQLException {
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

        return (pstmt.executeUpdate() > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger databaseLogin(String username, String password) throws SQLException {
        String sql = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        rs = pstmt.executeQuery();
        return (rs.next()) ? Messenger.SUCCESS : Messenger.FAIL;

    }

    public Messenger findUserDatabaseById(String userName) throws SQLException {
        String sql = "SELECT * from users where username = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, userName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID : %d \t username : %s \t name : %s \t phone : %s \t" +
                        " job : %s \t height : %f \t weight : %f\n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("job"),
                        rs.getFloat("height"),
                        rs.getFloat("weight"));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 존재 하지 않음.");
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger changeDatabasePassword(String userName, String password) throws SQLException {
        String sql = "update users set password = ? where username = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, userName);
        pstmt.setString(2, password);

        return (pstmt.executeUpdate() > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger databaseWithdrawal(String userName) throws SQLException {
        String sql = "delete from users where username = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, userName);

        return (pstmt.executeUpdate() > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger findUserDatabaseByName(String name) throws SQLException {
        String sql = "select * from users where name = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, name);

        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID : %d \t username : %s \t name : %s \t phone : %s \t" +
                                " job : %s \t height : %f \t weight : %f\n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("job"),
                        rs.getFloat("height"),
                        rs.getFloat("weight"));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 존재 하지 않음.");
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger findUserDatabase() throws SQLException {
        String sql = "select * from users";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.printf("ID : %d \t username : %s \t name : %s \t phone : %s \t" +
                                " job : %s \t height : %f \t weight : %f\n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("job"),
                        rs.getFloat("height"),
                        rs.getFloat("weight"));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 존재 하지 않음.");
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger findUserDatabaseByJob(String job) throws SQLException {
        String sql = "select * from users where job = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, job);

        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID : %d \t username : %s \t name : %s \t phone : %s \t" +
                                " job : %s \t height : %f \t weight : %f\n",
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("job"),
                        rs.getFloat("height"),
                        rs.getFloat("weight"));
                System.out.println();
            } while (rs.next());
        } else {
            System.out.println("데이터가 존재 하지 않음.");
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }

    public Messenger userCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS user_count FROM users";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("유저 수는 " + rs.getInt("user_count"));
            return Messenger.SUCCESS;
        } else {
            return Messenger.FAIL;
        }
    }
}