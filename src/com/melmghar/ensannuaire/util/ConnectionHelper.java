package com.melmghar.ensannuaire.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  final class ConnectionHelper {
	public static Connection CONNECTION;
	
	public static void connect() {
		
		
		try {
			Class.forName(Constent.DRIVER_NAME);
			CONNECTION   = DriverManager.getConnection(Constent.DB_PATH,Constent.DB_USER,Constent.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
