package GUI;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import USERS.Customer;
import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import mySQL_Connector.Connector;

public class RegistrationScreen extends Application  {


	TextField FirstName = new TextField();
	TextField LastName = new TextField();
	TextField Address = new TextField();
	TextField Zip = new TextField();
	TextField State = new TextField();
	TextField Username = new TextField();
	TextField Email = new TextField();
	TextField SSN = new TextField();
	TextField SecurityQuestion = new TextField();
	PasswordField Password = new PasswordField();
	PasswordField ConfirmPassword = new PasswordField();
	Button button = new Button();
	Button button0 = new Button();
	Label Title = new Label();



	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {
		
		
		Application.launch(args);

	}



	@Override

	public void start(Stage primaryStage) throws Exception {
		
		
		
		
		primaryStage.setTitle("Registration");

		primaryStage.setResizable(false);

		AnchorPane anchor = new AnchorPane();
		
		GridPane grid = new GridPane();
		
		anchor.setPadding(new Insets(0));
	
		
		



		Label firstNameLbl = new Label();

		firstNameLbl.setLayoutX(70.0);

		firstNameLbl.setLayoutY(81.0);

		firstNameLbl.setText("First Name: ");

		firstNameLbl.setFont(new Font(18.0));



		Label lastNameLbl = new Label();

		lastNameLbl.setLayoutX(71.0);

		lastNameLbl.setLayoutY(114.0);

		lastNameLbl.setText("Last Name: ");

		lastNameLbl.setFont(new Font(18.0));



		Label addressLbl = new Label();

		addressLbl.setLayoutX(94.0);

		addressLbl.setLayoutY(149.0);

		addressLbl.setText("Address: ");

		addressLbl.setFont(new Font(18.0));



		Label zipLbl = new Label();

		zipLbl.setLayoutX(84.0);

		zipLbl.setLayoutY(184.0);

		zipLbl.setText("Zip Code: ");

		zipLbl.setFont(new Font(18.0));



		Label stateLbl = new Label();

		stateLbl.setLayoutX(118.0);

		stateLbl.setLayoutY(221.0);

		stateLbl.setText("State: ");

		stateLbl.setFont(new Font(18.0));



		Label userLbl = new Label();

		userLbl.setLayoutX(74.0);

		userLbl.setLayoutY(256.0);

		userLbl.setText("Username: ");
	

		userLbl.setFont(new Font(18.0));



		Label passLbl = new Label();

		passLbl.setLayoutX(77.0);

		passLbl.setLayoutY(292.0);

		passLbl.setText("Password: ");

		passLbl.setFont(new Font(18.0));



		Label pconfirmPassLbl = new Label();

		pconfirmPassLbl.setLayoutX(76.0);

		pconfirmPassLbl.setLayoutY(325.0);

		pconfirmPassLbl.setText("  Confirm" + "\n Password: ");

		pconfirmPassLbl.setFont(new Font(18.0));



		Label emailLbl = new Label();

		emailLbl.setLayoutX(117.0);

		emailLbl.setLayoutY(385.0);

		emailLbl.setText("Email: ");

		emailLbl.setFont(new Font(18.0));



		Label ssnLbl = new Label();

		ssnLbl.setLayoutX(122.0);

		ssnLbl.setLayoutY(420.0);

		ssnLbl.setText("SSN: ");

		ssnLbl.setFont(new Font(18.0));




		FirstName.setLayoutX(174.0);

		FirstName.setLayoutY(83.0);

		FirstName.setPromptText("First Name");



		LastName.setLayoutX(174.0);

		LastName.setLayoutY(116.0);

		LastName.setPromptText("Last Name");



		Address.setLayoutX(174.0);

		Address.setLayoutY(151.0);

		Address.setPromptText("Address");



		Zip.setLayoutX(174.0);

		Zip.setLayoutY(186.0);

		Zip.setPromptText("#####");



		State.setLayoutX(174.0);

		State.setLayoutY(223.0);

		State.setPromptText("State");



		Username.setLayoutX(174.0);

		Username.setLayoutY(258.0);

		Username.setPromptText("Username");
		
		



		Email.setLayoutX(174.0);

		Email.setLayoutY(385.0);

		Email.setPromptText("Example@example.com");



		SSN.setLayoutX(174.0);

		SSN.setLayoutY(420.0);

		SSN.setPromptText("###-##-####");
		

		SecurityQuestion.setLayoutX(174.0);

		SecurityQuestion.setLayoutY(513.0);

		SecurityQuestion.setPromptText("Enter your answer here");



		Password.setLayoutX(174.0);

		Password.setLayoutY(292.0);

		Password.setPromptText("Password");
		
		
		
		



		ConfirmPassword.setLayoutX(174.0);

		ConfirmPassword.setLayoutY(345.0);

		ConfirmPassword.setPromptText("Confirm Password");
		
		
		
		
		final ComboBox<String> securityQuestionComboBox = new ComboBox<String>();

		securityQuestionComboBox.getItems().addAll("What is your favorite food?",

				"What elementary school did you attend?", "Who is your favorite actor?",

				"Where is your favorite place to eat?", "What is your favorite fruit?");


		securityQuestionComboBox.setLayoutX(174.0);
		securityQuestionComboBox.setLayoutY(477.0);

		securityQuestionComboBox.setValue("Choose Question");



		Label securityQuestionLabel = new Label("   Security" + "\n Question: ");
		
		securityQuestionLabel.setLayoutX(76.0);

		securityQuestionLabel.setLayoutY(457.0);
		securityQuestionLabel.setFont(new Font(18.0));



		button.setLayoutX(334.0);

		button.setLayoutY(565.0);

		button.setMnemonicParsing(false);
 
		button.setPrefHeight(25.0);

		button.setPrefWidth(105.0);

		button.setText("Submit");
		
		
			LoginScreen screen = new LoginScreen();
			try {
				screen.start(primaryStage);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		
		button.setOnAction(e -> {
			
			
			 Connection dbConnection = null;
				PreparedStatement preparedStatement = null;
				
			 try {

				if (checkUser(Username) == true && checkPass(Password, ConfirmPassword) == true ) {
				 
			   Customer cust = new Customer();
			   cust.setFirstName(FirstName.getText());
			   cust.setLastName(LastName.getText());
			   cust.setEmail(Email.getText());
			   cust.setUserNAME(Username.getText());
			   cust.setAddress(Address.getText());
			   cust.setZip(Zip.getText());
			   cust.setState(State.getText());
			   cust.setSecurityQuestion(SecurityQuestion.getText());
			   cust.setPassWORD(Password.getText());
			   cust.setConfirmPassword(ConfirmPassword.getText());
			   cust.setSSN(SSN.getText());
			   
			   
			  dbConnection = Connect();
			    String sql="Insert into Customer(firstName,lastName, email,userNAME,Address,Zip,State,SecurityQ,  Password, ConfirmPassword,SSN) VALUES (?,?,?,?,?,?,?,?,?,?,?)"; 
			    preparedStatement =  dbConnection.prepareStatement(sql);
			 
			    
			    preparedStatement.setString(1,cust.getFirstName()); 
			    preparedStatement.setString(2,cust.getLastName()); 
			    preparedStatement.setString(3,cust.getEmail()); 
			    preparedStatement.setString(4,cust.getUserNAME()); 
			    preparedStatement.setString(5,cust.getAddress());
			    preparedStatement.setString(6,cust.getZip()); 
			    preparedStatement.setString(7,cust.getState());
			    preparedStatement.setString(8,cust.getSecurityQuestion());
			    preparedStatement.setString(9,cust.getPassWORD()); 
			    preparedStatement.setString(10,cust.getConfirmPassword());
			    preparedStatement.setString(11,cust.getSSN()); 
			    
			   
			    preparedStatement.executeUpdate();
			    dbConnection.close(); 
			    preparedStatement.close(); 
			
				
			
			LoginScreen loginPage = new LoginScreen();
			
			loginPage.start(primaryStage);

			 }
			 }
			 catch(Exception e1) {
				e1.printStackTrace();
			 }
		});

		button0.setLayoutX(124.0);

		button0.setLayoutY(565.0);

		button0.setMnemonicParsing(false);
 
		button0.setPrefHeight(25.0);

		button0.setPrefWidth(155.0);

		button0.setText("Return to Login");
		
		
			LoginScreen screens = new LoginScreen();
			
			try {
				screens.start(primaryStage);
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		button0.setOnAction(e -> {
			try {
			screens.start(primaryStage);
			}catch(Exception el ) {
				el.printStackTrace();
			}
		});
		
			

		Title.setLayoutX(130.0);

		Title.setLayoutY(14.0);

		Title.setText("Registration for Flight Master");

		Title.setFont(new Font(24.0));



		anchor.getChildren().addAll(firstNameLbl,lastNameLbl,addressLbl,zipLbl, stateLbl,userLbl,passLbl,

				pconfirmPassLbl, emailLbl,ssnLbl,FirstName, LastName, Address, Zip, State,Username,

				Email, SSN, Password, ConfirmPassword, button, button0, Title,securityQuestionLabel,securityQuestionComboBox,SecurityQuestion);

		

		

		Scene scene = new Scene(anchor, 600, 700);

		primaryStage.setScene(scene);

		primaryStage.show();

		primaryStage.centerOnScreen();

	}
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
	public static boolean checkPass(PasswordField  pass, PasswordField passw) {
		char a = pass.getText().charAt(0);
		if (Character.isLowerCase(a)) {
			AlertBox.display("Error","Password must start with a capital letter!");
			return false;
		} else if (pass.getText().length() < 6) {
			AlertBox.display("Error", "Password must be longer than 6 characters");
			return false;
		}
		else if (!pass.getText().matches(".*\\d+.*")) {
			AlertBox.display("Error","Password must contain a number");
			return false;
		} else if (!pass.getText().equals(passw.getText())) {
			AlertBox.display("Error", "Passwords don't match");
		}
		
		// if password is already in the database pop box 
		return true;
	}
public static boolean checkUser(TextField user) {
	char a = user.getText().charAt(0);
	if (user.toString().length() <= 3) {
		AlertBox.display("Error","Username must be more than 3 characters");
		return false;
	}else if (Character.isLowerCase(a)) {
		AlertBox.display("Error","Username must start with a capital letter!");
		return false;
}
	return true;
}
	 
	 
	}




		

	
