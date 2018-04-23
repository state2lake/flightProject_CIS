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

public class Customer extends RegistrationScreen {


	String firstName;
	String lastName;
	String Address;
	String Zip;
	String State;
	String email;
	String SSN;
	String SecurityQuestion;
	String userName;
	String passWord;
	String confirmPassword;
	
	ArrayList<String> list = new ArrayList<String>();

	public Customer() {

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

		String dash = "-";
		char one = sSN.charAt(3);
		char two = sSN.charAt(6);

		if (Character.isLetter(one) || Character.isDigit(one)) {
			System.out.println("Illegal format");
		}
		int dashCount = 0;
		for(int i = 0; i < sSN.length(); i++) {
		if(sSN.contains(dash) ) {
			dashCount++;
		}
		
		
		}
		if(dashCount < 2) 
			System.out.println("Illegal format - dash");
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

		String at = "@";
		String com = ".com";
		if (!email.contains(at)) {
			System.out.println("Invalid, email must have " + at + " symbol");
		}
		if (!email.contains(com)) {
			System.out.println("Sorry, I don't recognize that extension (Password must contain .com) ");
		}

	}

	public String getUserNAME() {
		return userName;
	}

	public void setUserNAME(String string) {
		this.userName = string;
		if (string.toString().length() <= 3) {
			System.out.println("Invalid, username must be more than 3 characters ");
		}
	}

	public String getPassWORD() {
		return passWord;
	}

	public void setPassWORD(String passWORD) {
		this.passWord= passWORD;

		char a = passWORD.charAt(0);
		if (Character.isLowerCase(a)) {
			System.out.println("Invalid, password must start with a capital letter ");
		} else if (passWORD.length() < 6) {
			System.out.println("Invalid, password must be longer than 6 characters");
		}
		else if (!passWORD.matches(".*\\d+.*")) {
			System.out.println("Invalid, password must contain a number");
		}
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