package com.dennis.api.menu;

import com.dennis.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static MenuRepository instance;

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
    public List<String> getMenuList(String menuName) throws SQLException {
        String sql = "Select item, category from menu where category = ?";
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
}
