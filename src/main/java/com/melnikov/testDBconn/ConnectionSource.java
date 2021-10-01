package com.melnikov.testDBconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSource {

    private final String connString = "jdbc:mysql://localhost:3306/new_schema";
    private final String user = "root";
    private final String pass = "admin";

    private static final ConnectionSource instance = new ConnectionSource();

    public static ConnectionSource instance() {
        return instance;
    }

    public Connection createConnection() throws SQLException {

        return DriverManager.getConnection(connString, user, pass);
    }

    public ConnectionSource(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
