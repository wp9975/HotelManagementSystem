package com.iie.hotelms.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection dbLink;

    public static Connection getConnection(){
        String dbName = "hotelms";
        String dbUser = "root1";
        String dbPassword = "ZAQ!2wsx";
        String url = "jdbc:mysql://hotel.mysql.database.azure.com:3306/hotelms";
//ready
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return dbLink;
    }

}
