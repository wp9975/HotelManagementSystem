package com.iie.hotelms.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection dbLink;

    public static Connection getConnection(){
        String dbName = "hotelms";
        String dbUser = "root";
        String dbPassword = "root";
        String url = "jdbc:mysql://localhost/"+ dbName;
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
