
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.control.TextField;

public class Customer {

	String SSN;
	String firstName;
	TextField txtFirstName;
	String lastName;
	String email;
	String userNAME;
	String passWORD;
	String securityQuestion;
	
	ArrayList<String> list = new ArrayList<String>();

	Customer() {

	}

	Customer(String newUserNAME, String newPassWORD) {

	}

	Customer(String newSSN, String newfirstName, String newlastName, String newEmail, String newuserNAME,
			String newpassWORD) {
		SSN = newSSN;
		firstName = newfirstName;
		lastName = newlastName;
		email = newEmail;
		userNAME = newuserNAME;
		passWORD = newpassWORD;
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
		return userNAME;
	}

	public void setUserNAME(String userNAME) {
		this.userNAME = userNAME;
		if (userNAME.length() <= 3) {
			System.out.println("Invalid, username must be more than 3 characters ");
		}
	}

	public String getPassWORD() {
		return passWORD;
	}

	public void setPassWORD(String passWORD) {
		this.passWORD = passWORD;

		char a = passWORD.charAt(0);
		if (Character.isLowerCase(a)) {
			System.out.println("Invalid, password must start with a capital letter ");
		} else if (passWORD.length() < 6) {
			System.out.println("Invalid, password must be longer than 6 characters");
		} else if (!passWORD.matches(".*\\d+.*")) {
			System.out.println("Invalid, password must contain a number");
		}
	}

//	public static ArrayList<String> list () {
//		
//	}

	// this is where I want to put the business logic to the class.

}

// if i make this static I can access it outside of these classes with the name
// of the outer class
class databaseOperation {

	/*
	 * Please remember that Customer cust belongs in every method. I want to get
	 * info from a textField where they register
	 * 
	 * I have Constructor up with different parameters. make sure that is correct
	 * 4/20/18 -Jonathan
	 */

	 public void Register(Customer cust) throws ClassNotFoundException,
	 SQLException {
	 Customer a = new Customer();
	 // all should have txtField get text in parameters
	// a.setSSN();
	 a.setFirstName("");
	 a.setLastName("");
	 a.setEmail("");
	 a.setUserNAME("");
	
	 // now insert that info into mySQL
	
	 }

	
}