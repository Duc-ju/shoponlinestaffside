/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author os_hoangpn
 */
public class ConnectDB {

    private static Connection connect = null;

    /**
     * Check Driver connect to MySQL
     */
    public static Connection openConnect(){
    	String jdbcURL = "jdbc:mysql://localhost:3306/ShopOnline?useSSL=false";
		String jdbcUsername = "root";
		String jdbcPassword = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			System.out.println("Connection to database failed");
		}
		return connect;
    }

    public static void main(String[] args){
        System.out.println(ConnectDB.openConnect());
    }
}
