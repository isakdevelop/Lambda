package com.dennis.api.article;

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

    public String createArticle(String subject, String content, String writer) throws SQLException {
        String sql = "insert into article(title, content, writer) " +
                "VALUES (?, ?, ?)";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, subject);
        pdst.setString(2, content);
        pdst.setString(3, writer);

        int result = pdst.executeUpdate();
        return (result > 0) ? "기사 작성 완료" : "기사 작성 실패";
    }

    public String modifyArticle(int id, String subject, String content) throws SQLException {
        String sql = "UPDATE article SET subject = ?, content = ? where id = ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setString(1, subject);
        pdst.setString(2, content);
        pdst.setInt(3, id);

        int result = pdst.executeUpdate();
        return (result > 0) ? "기사 수정 완료" : "기사 수정 실패";
    }

    public String deleteArticle(int id) throws SQLException {
        String sql = "Delete from article where id = ?";
        PreparedStatement pdst = connection.prepareStatement(sql);
        pdst.setInt(1, id);

        int result = pdst.executeUpdate();
        return (result > 0) ?"기사 삭제 완료" : "기사 삭제 실패";
    }

    public List<?> searchArticleByTitle(String title) throws SQLException {
        String sql = "select * from article where title = Like ?";
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

        }else{
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public List<?> searchArticleByContent(String str) throws SQLException {
        String sql = "select * from article where content = Like ?";
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

        }else{
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public List<?> searchArticleByWriter(String writer) throws SQLException {
        String sql = "select * from article where writer = ?";
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

        }else{
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public List findAll() throws SQLException {
        List<com.dennis.api.article.Article> ls = new ArrayList<>();
        String sql = "select * from articles";
        ResultSet rs = connection.prepareStatement(sql).executeQuery();

        if (rs.next())  {
            do {
                ls.add(com.dennis.api.article.Article.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .registerDate(rs.getString("registerDate"))
                        .build());

            } while (rs.next());
        } else {
            System.out.println("no data");
        }

        return ls;
    }
}
