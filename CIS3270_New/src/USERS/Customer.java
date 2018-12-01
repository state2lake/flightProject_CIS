package USERS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GUI.RegistrationScreen;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Customer  {


	private String firstName;
	private String lastName;
	private String Address;
	private String Zip;
	private String State;
	private String email;
	private String SSN;
	private String SecurityQuestion;
	private String userName;
	private String passWord;
	private String confirmPassword;
	
	ArrayList<String> list = new ArrayList<String>();

	public Customer() {

	}
	public Customer(String username, String password) {
		this.userName = username;
		this.passWord = password;
	}

	public Customer(String firstName, String lastName, String address, String zip, String state, String email,
			String sSN, String securityQuestion, String userName, String passWord, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		Zip = zip;
		State = state;
		this.email = email;
		SSN = sSN;
		SecurityQuestion = securityQuestion;
		this.userName = userName;
		this.passWord = passWord;
		this.confirmPassword = confirmPassword;
		
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;

		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;


	}

	public String getUserNAME() {
		return userName;
	}

	public void setUserNAME(String string) {
		this.userName = string;
		
	}

	public String getPassWORD() {
		return passWord;
	}

	public void setPassWORD(String passWORD) {
		this.passWord= passWORD;

	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getSecurityQuestion() {
		return SecurityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		SecurityQuestion = securityQuestion;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	
	


	
	
}