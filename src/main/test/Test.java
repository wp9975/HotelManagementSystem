package com.iie.hotelms.controllers;

import com.iie.hotelms.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.testng.Assert.*;

public class Test {

    @org.testng.annotations.Test
    public void testConnection() throws Exception {
        System.out.println("Connection");
        Connection result = DatabaseConnection.getConnection();
        assertEquals(result == null,true);
    }

}
