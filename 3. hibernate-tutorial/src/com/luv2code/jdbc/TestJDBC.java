package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {

		ConnectMySQL();
		ConnectSQLITE();

	}

	public static void ConnectMySQL() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
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

	public static void ConnectSQLITE() {

		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
			// create a connection to the database
			
			System.out.println("Connecting to database: " + url);
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
