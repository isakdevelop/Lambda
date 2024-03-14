package com.dennis.api.article;

import com.dennis.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private final static ArticleRepository instance;
    private final Connection connection;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArticleRepository getInstance()   {
        return instance;
    }
    public ArticleRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dennisdb",
                "root",
                "rootroot"
        );
    }

    public Messenger createArticle(String subject, String content, String writer) throws SQLException {
        String sql = "insert into articles(title, content, writer) " +
                "VALUES (?, ?, ?)";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, subject);
        pdst.setString(2, content);
        pdst.setString(3, writer);

        int result = pdst.executeUpdate();
        return (result > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger modifyArticle(int id, String subject, String content) throws SQLException {
        String sql = "UPDATE articles SET subject = ?, content = ? where id = ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, subject);
        pdst.setString(2, content);
        pdst.setInt(3, id);

        int result = pdst.executeUpdate();
        return (result > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger deleteArticle(int id) throws SQLException {
        String sql = "Delete from articles where id = ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setInt(1, id);

        int result = pdst.executeUpdate();
        return (result > 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger searchArticleByTitle(String title) throws SQLException {
        String sql = "select * from articles where title = Like ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, "%" + title + "%");

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

            return Messenger.SUCCESS;
        }else{
            return Messenger.FAIL;
        }
    }

    public Messenger searchArticleByContent(String str) throws SQLException {
        String sql = "select * from articles where content = Like ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, "%" + str + "%");

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

            return Messenger.SUCCESS;
        }else{
            return Messenger.FAIL;
        }
    }

    public Messenger searchArticleByWriter(String writer) throws SQLException {
        String sql = "select * from articles where writer = ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, writer);

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

            return Messenger.SUCCESS;
        }else{
            return Messenger.FAIL;
        }
    }

    public Messenger findAll() throws SQLException {
        String sql = "select * from articles";
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

            return Messenger.SUCCESS;
        }else{
            return Messenger.FAIL;
        }
    }
}
