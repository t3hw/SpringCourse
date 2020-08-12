package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {

		ConnectMySQL();
		//ConnectSQLITE();

	}

	public static void ConnectMySQL() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		Connection myConn = null;
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection Succesful");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (myConn != null) {
					myConn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
