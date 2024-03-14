package com.dennis.api.common;

import com.dennis.api.enums.Messenger;

import java.sql.*;

public class CommonRepository {
    private static CommonRepository instance;

    static {
        try {
            instance = new CommonRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private CommonRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot"
        );
    }
    public static CommonRepository getInstance() {
        return instance;
    }
    public Messenger getMenuList(String menuName) throws SQLException {
        String sql = "Select item, category from menu where category = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, menuName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("%s\n", rs.getString("item"));
            } while (rs.next());
        } else {
            return Messenger.FAIL;
        }
        return Messenger.SUCCESS;
    }
}
