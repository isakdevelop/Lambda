package repository;

import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}
