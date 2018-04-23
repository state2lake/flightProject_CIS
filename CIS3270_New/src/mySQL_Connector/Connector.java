package mySQL_Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import java.util.Scanner;

import USERS.Customer;



public class Connector {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Connect();
		selectRecordsFromTable();
	}
/*
 * I created a method for connect to keep things neat in the main method 
 * I am trying to create some methods for common SQL queries but currently can't get table to print on console 4/20/18
 * 
 * Once i do this for about 3 or for common queries I want to create a database connector class that plays between Logic and mySQL Databse 
 * 
 * - Jonathan
 * 
 * */
	public static Connection Connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270", "root", "Tsiknus41");
		} catch (Exception e) {
			System.out.println("Can not connect");
		}
		if (con != null) {
			System.out.println("Connected Successfully");
		}
		return con;
	}

	public static void selectRecordsFromTable() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT firstName from CIS3270.Customer";
		try {
			dbConnection = Connect();
			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(selectSQL);
			

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String firstName = rs.getString("firstName");
				

				System.out.println(firstName);
				

			}

		} catch (SQLException e) {

			System.out.println("Error");

		}

	}
	 @SuppressWarnings("null")
	public void insert (Customer cust)  throws ClassNotFoundException,
	 SQLException
	 {
		 Connection dbConnection = null;
			PreparedStatement preparedStatement = null;
			
		 
		   
		  
		    String sql="Insert into CIS3270.Customer(SSN,firstName,lastName, email,userNAME)VALUES (?,?,?,?,?)"; 
		    preparedStatement = (PreparedStatement) dbConnection.prepareStatement(sql);
		    preparedStatement.setString(1,cust.getSSN()); 
		    preparedStatement.setString(2,cust.getFirstName()); 
		    preparedStatement.setString(3,cust.getLastName()); 
		    preparedStatement.setString(4,cust.getEmail()); 
		    preparedStatement.setString(5,cust.getUserNAME()); 
		    
		   
		    preparedStatement.executeBatch(); 
		    preparedStatement.executeUpdate(); 
		    dbConnection.close(); 
		    preparedStatement.close(); 
	 
	 }

	
}
