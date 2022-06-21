package com.iie.hotelms.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.iie.hotelms.database.DatabaseConnection.dbLink;

public class dbMassage {

    public static void massageInsert(String date, String startHour, Integer idGuest, Integer idMassage){

        try {
            PreparedStatement stmt = dbLink.prepareStatement("INSERT INTO `hotelms`.`r_massages_reservation`" +
                    "(`date`, `start_hour`, `end_hour`, `price`, `id_worker`, `id_massage`, `id_guest`) " +
                    "VALUES ( ? , ?, null, null, null, ?, ?);");
            stmt.setString(1, date);
            stmt.setString(2, startHour);
            stmt.setInt(3, idGuest);
            stmt.setInt(4, idMassage);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



}
