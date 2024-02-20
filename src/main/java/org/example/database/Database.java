package org.example.database;

import org.example.prefs.Prefs;

import java.sql.*;

public class  Database{
    private static final Database INSTANCE = new Database();
    private final Connection connection;
    private Database(){
        try {
            String dbUrl = new Prefs().getString(Prefs.DB_URL);
            String dbUser = new Prefs().getString(Prefs.DB_USER);
            String dbPass = new Prefs().getString(Prefs.DB_PASS);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Database getInstance(){
        return INSTANCE;
    }
    public int executeUpdate(String sql){
        try(Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConnection(){
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}