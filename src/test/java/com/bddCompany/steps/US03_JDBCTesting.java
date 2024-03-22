package com.bddCompany.steps;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class US03_JDBCTesting {
    @Given("as user make sure you are able to retrieve the data from the employee table")
    public void as_user_make_sure_you_are_able_to_retrieve_the_data_from_the_employee_table() throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@18.208.213.6:1521:XE";
        String dbPassword = "hr";
        String dbUsername = "hr";
        //Create the connection
        //DriverManager class getConnection Method will help to connect database
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        //It will help us to execute queries
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //ResultSet will store data after execution. It stores only data(there is no table info)
        ResultSet rs = statement.executeQuery("select * from Employees");
        //create rsmd to get column name and count
        ResultSetMetaData rsmd = rs.getMetaData();
        rs.next();        //bring the cursor to the first row
        System.out.println(rs.getString(1)+" "+rs.getString(2));

        rs.last();
        int row = rs.getRow();
        System.out.println("Last Row Number : " + row);
        rs.first();
        while(rs.next()){
            System.out.println(rs.getString(2)+" "+ rs.getString(4));
        }


        rs.beforeFirst();  //before first row


        rs.next();// we need to move to first row


        //how many columns we have
        int columnCount = rsmd.getColumnCount();
        System.out.println(columnCount);


        //iterate through each row
        while (rs.next()) {
            //create an empty map to hold one row of information
            Map<String, Object> rowMap = new HashMap<>();
            //iterate each column dynamically to fill the map
            for (int i = 1; i <= columnCount; i++) {
                //key = column name, value= column value
                rowMap.put(rsmd.getColumnName(i), rs.getString(i));
            }

            System.out.println(rowMap);

        }

        rs.beforeFirst();  //before first row again


        rs.next();// we need to move to first row


        Map<String,Object> oneRowMap = new HashMap<>();

        System.out.println("------show only first row as map--------");
        for (int i = 1; i <= columnCount; i++) {
            //key = column name, value= column value
            oneRowMap.put(rsmd.getColumnName(i),rs.getString(i));
        }

        System.out.println(oneRowMap);

        System.out.println("--------ABSOLUTE goes to specefic Row ---------");
        rs.absolute(46); //true if the cursor is moved to a position in this ResultSet object; false if the cursor is before the first row or after the last row
        System.out.println(rs.getString(1)+" "+rs.getString(2));


        Map<String,Object> row46AsMap = new HashMap<>();

        System.out.println("------show only show row  46 as map--------");
        for (int i = 1; i <= columnCount; i++) {
            //key = column name, value= column value
            row46AsMap.put(rsmd.getColumnName(i),rs.getString(i));
        }

        System.out.println(row46AsMap);
    }
}
