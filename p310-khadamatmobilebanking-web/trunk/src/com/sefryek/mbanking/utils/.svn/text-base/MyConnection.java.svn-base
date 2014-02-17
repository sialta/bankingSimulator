package com.sefryek.mbanking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/10/13
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyConnection {

    public Connection createConnection() throws SQLException {

        System.out.println("--------  JDBC Connection Testing ------");

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your mysql JDBC Driver?");
            e.printStackTrace();

        }

        System.out.println("mysql JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_banking","root", "");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }


}
