package com.mb.brc.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

   public static Connection startConnection() throws Exception {

 /*   	String url = "jdbc:mysql://115.112.207.178:3311/Property";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "app_user";
        String password = "JOlsdf@s23KoewJO09use"; */
        
        ///Live config
    	String url = "jdbc:mysql://115.112.207.177:3310/Property";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "mbread_usr75"; 
        String password = "DNo@234nOLHIosfdnoiuwNOIdsf";
        


        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url, userName,password);

        return conn;
    }
    
   
    
    public static void closeConnection(Connection conn) {
        try {

            conn.close();

        } catch (Exception e) {

        }

    }
    
    
    
}