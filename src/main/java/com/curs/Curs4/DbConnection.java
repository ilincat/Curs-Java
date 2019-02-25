package com.curs.Curs4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DbConnection {
	private Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static Connection connection = null;

	// static method to create instance of Singleton class
	public static Connection getInstance() {
		if (connection == null)
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager
						.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CursJava;" + "user=dev;password=Password2.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		return connection;
	}

	public static void addUser(String name, String password) {
		try {
			preparedStatement = connection.prepareStatement("Insert into users(username,password) values (?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Boolean exists(String name) {
		try {
			preparedStatement = connection.prepareStatement("select * from users where username=?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static String getPassword(String name) {
		try {
			preparedStatement = connection.prepareStatement("select password from users where username=?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
