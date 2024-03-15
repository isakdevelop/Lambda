package com.dennis.api.account;

import com.dennis.api.enums.Messenger;

import java.sql.*;

public class AccountRepository {
    private static AccountRepository instance;

    static {
        try {
            instance = new AccountRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public AccountRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot"
        );
    }

    public static AccountRepository getInstance() {
        return instance;
    }

    public Messenger createAccount(Account account) throws SQLException {
        String sql = "insert into account(accountNumber, accountHolder, balance, transactionDate, transactionType)" +
                "values(?, ?, ?, ?, ?)";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, account.getAccountNumber());
        pstmt.setString(2, account.getAccountHolder());
        pstmt.setInt(3, account.getBalance().intValue());
        pstmt.setString(4, String.valueOf(account.getTransactionDate()));
        pstmt.setString(5, account.getTransactionType());

        return (pstmt.executeUpdate() > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }
}
