package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot"
        );
    }
    public static MenuRepository getInstance() {
        return instance;
    }

    public Messenger makeTable() throws SQLException {
        String sql = "create table if not exists menu ("+
                "id int primary key auto_increment," +
                "item varchar(30) not null," +
                "category varchar(50) not null)";
        pstmt =  connection.prepareStatement(sql);

        return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger removeTable() throws SQLException {
        String sql = "drop table if exists menu";
        pstmt = connection.prepareStatement(sql);
        return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger insertMenu(Menu menu) throws SQLException {
        String sql = "INSERT INTO menu(category, item) VALUES(?,?)";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, menu.getCategory());
        pstmt.setString(2, menu.getItem());
        return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public List<String> getMenuList(String menuName) throws SQLException {
        String sql = "Select item from menu where category = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, menuName);
        rs = pstmt.executeQuery();

        List<String> ls = new ArrayList<>();

        while(rs.next()) {
            ls.add(rs.getString("item"));
        }
        return ls.isEmpty() ? null : ls;

//        if (rs.next()) {
//            do {
//                // System.out.printf("%s\n", rs.getString("item"));
//            } while (rs.next());
//        } else {
//            return Messenger.FAIL;
//        }
//        return Messenger.SUCCESS;
    }

    public Messenger truncateTable() throws SQLException {
        String sql = "TRUNCATE TABLE menu";
        pstmt = connection.prepareStatement(sql);
        return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
    }
}
