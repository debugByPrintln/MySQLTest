package com.melnikov.testDBconn.MyUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RSPrinter {
    public static void printMyRS(ResultSet resultSet) throws SQLException {
        System.out.println("---------------------------------------------------------------------");
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
