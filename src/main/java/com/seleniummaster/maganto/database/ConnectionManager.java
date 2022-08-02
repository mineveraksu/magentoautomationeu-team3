package com.seleniummaster.maganto.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //create a method to connect to database
    public static Connection connectToDatabaseServer(String dburl, String dbPort,
                                                     String defaultDatabase, String dbUserName, String dbPassword) {
        //define a connection object
        Connection connection = null;
        String MYSQL_Driver = "com.mysql.cj.jdbc.Driver";//mysql

                try {
                    Class.forName(MYSQL_Driver).newInstance();//initialize the MySQL server driver
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                String mySQLConnectionURL = "jdbc:mysql://" + dburl + ":" + dbPort + "/" + defaultDatabase + "?useSSL=false";
                //when work write true(https ...secure)
                try {
                    connection = DriverManager.getConnection(mySQLConnectionURL, dbUserName, dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        //verify connected or not
        try {
            if (!connection.isClosed()) {
                System.out.println("Database connection is established!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    //write a method to close the connection/define a method to disconnect from database server
    public static void closeDatabaseConnection(Connection connection) {
        try {
            if (connection.isClosed()) {
                System.out.println("Connection has already been closed!!");
            } else {
                connection.close();
                System.out.println("Connection is closed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
