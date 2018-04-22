package GUI;

import javafx.application.Application;
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

public class RegistrationScreen extends Application  {


	TextField FirstName = new TextField();
	TextField LastName = new TextField();
	TextField Address = new TextField();
	TextField Zip = new TextField();
	TextField State = new TextField();
	TextField Username = new TextField();
	TextField Email = new TextField();
	TextField SSN = new TextField();
	TextField SecurityQueston = new TextField();
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

		primaryStage.setTitle("Register");

		primaryStage.setResizable(false);

		AnchorPane anchor = new AnchorPane();

		anchor.setPadding(new Insets(0));



		Label firstNameLbl = new Label();

		firstNameLbl.setLayoutX(70.0);

		firstNameLbl.setLayoutY(81.0);

		firstNameLbl.setText("First Name");

		firstNameLbl.setFont(new Font(20.0));



		Label lastNameLbl = new Label();

		lastNameLbl.setLayoutX(71.0);

		lastNameLbl.setLayoutY(114.0);

		lastNameLbl.setText("Last Name");

		lastNameLbl.setFont(new Font(20.0));



		Label addressLbl = new Label();

		addressLbl.setLayoutX(94.0);

		addressLbl.setLayoutY(149.0);

		addressLbl.setText("Address");

		addressLbl.setFont(new Font(20.0));



		Label zipLbl = new Label();

		zipLbl.setLayoutX(84.0);

		zipLbl.setLayoutY(184.0);

		zipLbl.setText("Zip Code");

		zipLbl.setFont(new Font(20.0));



		Label stateLbl = new Label();

		stateLbl.setLayoutX(118.0);

		stateLbl.setLayoutY(221.0);

		stateLbl.setText("State");

		stateLbl.setFont(new Font(20.0));



		Label userLbl = new Label();

		userLbl.setLayoutX(74.0);

		userLbl.setLayoutY(256.0);

		userLbl.setText("Username");

		userLbl.setFont(new Font(20.0));



		Label passLbl = new Label();

		passLbl.setLayoutX(77.0);

		passLbl.setLayoutY(287.0);

		passLbl.setText("Password");

		passLbl.setFont(new Font(20.0));



		Label pconfirmPassLbl = new Label();

		pconfirmPassLbl.setLayoutX(3.0);

		pconfirmPassLbl.setLayoutY(329.0);

		pconfirmPassLbl.setText("Confirm Password");

		pconfirmPassLbl.setFont(new Font(20.0));



		Label emailLbl = new Label();

		emailLbl.setLayoutX(117.0);

		emailLbl.setLayoutY(362.0);

		emailLbl.setText("Email");

		emailLbl.setFont(new Font(20.0));



		Label ssnLbl = new Label();

		ssnLbl.setLayoutX(122.0);

		ssnLbl.setLayoutY(392.0);

		ssnLbl.setText("SSN");

		ssnLbl.setFont(new Font(20.0));




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

		Email.setLayoutY(364.0);

		Email.setPromptText("Example@example.com");



		SSN.setLayoutX(174.0);

		SSN.setLayoutY(398.0);

		SSN.setPromptText("###-##-####");
		

		SecurityQueston.setLayoutX(174.0);

		SecurityQueston.setLayoutY(465.0);

		SecurityQueston.setPromptText("Enter your answer here");



		Password.setLayoutX(174.0);

		Password.setLayoutY(290.0);

		Password.setPromptText("Password");



		ConfirmPassword.setLayoutX(174.0);

		ConfirmPassword.setLayoutY(329.0);

		ConfirmPassword.setPromptText("Confirm Password");
		
		
		final ComboBox<String> securityQuestionComboBox = new ComboBox<String>();

		securityQuestionComboBox.getItems().addAll("What is your favorite food?",

				"What elementary school did you attend?", "Who is your favorite actor?",

				"Where is your favorite place to eat?", "What is your favorite fruit?");


		securityQuestionComboBox.setLayoutX(174.0);
		securityQuestionComboBox.setLayoutY(432.0);

		securityQuestionComboBox.setValue("Choose Question");



		Label securityQuestionLabel = new Label("Security Question ");
		
		securityQuestionLabel.setLayoutX(5.0);

		securityQuestionLabel.setLayoutY(428.0);
		securityQuestionLabel.setFont(new Font(20.0));



		button.setLayoutX(234.0);

		button.setLayoutY(524.0);

		button.setMnemonicParsing(false);

		button.setPrefHeight(25.0);

		button.setPrefWidth(105.0);

		button.setText("Register");

		button.setOnAction(e -> {
			

			LoginScreen loginPage = new LoginScreen();
			
			loginPage.start(primaryStage);


		});



		button0.setLayoutX(104.0);

		button0.setLayoutY(524.0);

		button0.setMnemonicParsing(false);

		button0.setText("Forgot password");

		button0.setOnAction(e -> {

	

		});



		Title.setLayoutX(130.0);

		Title.setLayoutY(14.0);

		Title.setText("Register User");

		Title.setFont(new Font(24.0));



		anchor.getChildren().addAll(firstNameLbl,lastNameLbl,addressLbl,zipLbl, stateLbl,userLbl,passLbl,

				pconfirmPassLbl, emailLbl,ssnLbl,FirstName, LastName, Address, Zip, State,Username,

				Email, SSN, Password, ConfirmPassword, button, button0, Title,securityQuestionLabel,securityQuestionComboBox,SecurityQueston);

		

		

		Scene scene = new Scene(anchor, 440, 550);

		primaryStage.setScene(scene);

		primaryStage.show();

		primaryStage.centerOnScreen();

	}


	}




		

	
