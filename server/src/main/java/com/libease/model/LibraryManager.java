package com.libease.model;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/*
 * シングルトンクラスとして定義する
 */
public class LibraryManager {
    private static LibraryManager instance = null;
    private final DataSource dataSource;

    /*
     * コンストラクタを直接コール出来ないようにprivateにする。シングルトンクラスだから
     */
    private LibraryManager() {
        // コネクションプールを設定
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        dataSource = basicDataSource;
    }

    /*
     * このクラスを使用するときにはこのメソッドを使ってインスタンスを取得する
     */
    public static synchronized LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    public List<User> getUsersInfoByQuery(int userId, String userName) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn
                        .prepareStatement("SELECT * FROM Users WHERE user_id = ? or user_name Like ?")) {
            // SELECT文を実行
            stmt.setInt(1, userId);
            stmt.setString(2, "%" + userName + "%");
            String sql = stmt.toString();
            System.out.println("SQL: " + sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                users.add(user);
            }
        }
        return users;
    }

    public List<User> getUsersInfoAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users")) {
            // SELECT文を実行
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                users.add(user);
            }
        }
        return users;
    }

    public List<User> getUsersInfo(Integer userId) throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE user_id = ?")) {
            // SELECT文を実行
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                users.add(user);
            }
        }
        return users;
    }

    /*
     * `
     * 単一テーブルを更新するためのサンプルコード
     */
    public void executeInsert(String name, String country) throws SQLException {
        try (Connection conn = dataSource.getConnection();

                PreparedStatement stmt = conn.prepareStatement("")) {
            // INSERT文を実行
            stmt.setString(1, name);
            stmt.setString(2, country);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " rows affected.");
        }
    }

    /*
     * `
     * 複数テーブルを更新するためのサンプルコード
     */
    public void sample() throws SQLException {
        boolean isThrowException = true;
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement1 = connection.prepareStatement("");
                    PreparedStatement statement2 = connection.prepareStatement("#")) {
                statement1.executeUpdate();
                if (isThrowException) {
                    throw new SQLException();
                }
                statement2.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        }
    }
}
