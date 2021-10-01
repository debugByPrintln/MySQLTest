package com.melnikov.testDBconn;

import com.melnikov.testDBconn.MyUtils.RSPrinter;

import java.sql.*;

public class MyMain {

    public static void main(String[] args) throws SQLException {
        ConnectionSource source = ConnectionSource.instance();

        //language=MySQL
        String selectAllFromDB = "SELECT * FROM test_table";
        String addNewRow = "INSERT INTO test_table VALUES (10, 'JORA')";
        String removeRow = "DELETE FROM test_table WHERE id = 10";


        try(Connection connection = source.createConnection();
            PreparedStatement selectAll = connection.prepareStatement(selectAllFromDB);
            PreparedStatement addNew = connection.prepareStatement(addNewRow);
            PreparedStatement removeLast = connection.prepareStatement(removeRow)){

            RSPrinter.printMyRS(selectAll.executeQuery());
            addNew.execute();
            RSPrinter.printMyRS(selectAll.executeQuery());
            removeLast.execute();
            RSPrinter.printMyRS(selectAll.executeQuery());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
