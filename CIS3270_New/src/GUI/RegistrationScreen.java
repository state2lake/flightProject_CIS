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

	


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Registration For Flight Master");

		GridPane gridPane = RegistrationForm();
		// Add UI controls to the registration form grid pane
		addUIControls(gridPane);
		// Dimensions of grid
		Scene scene = new Scene(gridPane, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane RegistrationForm() {
		GridPane gridPane = new GridPane();

		// Set Visual for the grid pane
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(100, 100, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		return gridPane;
	}

	private void addUIControls(GridPane gridPane) {
		
		// Add Header
		Label headerLabel = new Label("Registration");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		// Add First Name Label and Field
		Label firstNameLabel = new Label("First Name : ");
		gridPane.add(firstNameLabel, 0, 1);
		TextField firstNameField = new TextField();
		firstNameField.setPrefHeight(40);
		gridPane.add(firstNameField, 1, 1);

		// Add Last Name Label and Field
		Label lastNameLabel = new Label("LastName : ");
		gridPane.add(lastNameLabel, 0, 2);
		TextField lastNameField = new TextField();
		lastNameField.setPrefHeight(40);
		gridPane.add(lastNameField, 1, 2);

		// Add Address Label and Field
		Label addressLabel = new Label("Address : ");
		gridPane.add(addressLabel, 0, 3);
		TextField addressField = new TextField();
		addressField.setPrefHeight(40);
		gridPane.add(addressField, 1, 3);

		// Add Zip Label and Field
		Label zipLabel = new Label("Zip Code : ");
		gridPane.add(zipLabel, 0, 4);
		TextField zipField = new TextField();
		zipField.setPrefHeight(40);
		gridPane.add(zipField, 1, 4);

		// Add State Label and Field
		Label stateLabel = new Label("State :");
		gridPane.add(stateLabel, 0, 5);
		TextField stateField = new TextField();
		stateField.setPrefHeight(40);
		gridPane.add(stateField, 1, 5);

		// Add Username Label and Field
		Label userLabel = new Label("Username :");
		gridPane.add(userLabel, 0, 6);
		TextField userField = new TextField();
		userField.setPrefHeight(40);
		gridPane.add(userField, 1, 6);

		// Add Password Label and Field
		Label passLabel = new Label("Password :");
		gridPane.add(passLabel, 0, 7);
		TextField passField = new TextField();
		passField.setPrefHeight(40);
		gridPane.add(passField, 1, 7);

		// Add email label and field
		Label emailLabel = new Label("Email :");
		gridPane.add(emailLabel, 0, 8);
		TextField emailField = new TextField();
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 1, 8);

		// Add SSN label and field
		Label ssnLabel = new Label("SSN :");
		gridPane.add(ssnLabel, 0, 9);
		TextField ssnField = new TextField();
		ssnField.setPrefHeight(40);
		gridPane.add(ssnField, 1, 9);

		// Add drop down box for security question
		final ComboBox<String> securityQuestionComboBox = new ComboBox<String>();
		securityQuestionComboBox.getItems().addAll("What is your favorite food?",
				"What elementary school did you attend?", "Who is your favorite actor?",
				"Where is your favorite place to eat?", "What is your favorite fruit?");

		securityQuestionComboBox.setValue("Choose Question");

		Label securityQuestionLabel = new Label("Security Question :");
		gridPane.add(securityQuestionLabel, 0, 10);
		gridPane.add(securityQuestionComboBox, 1, 10);

		/**
		 * //Add Security Question label and field Label securityQuestionLabel =
		 * new Label ("Security Question :");
		 * gridPane.add(securityQuestionLabel, 0, 10); TextField
		 * securityQuestionField = new TextField();
		 * securityQuestionField.setPrefHeight(40);
		 * gridPane.add(securityQuestionField, 1, 10);
		 * 
		 **/

		// Add Security Answer label and field
		Label securityAnswerLabel = new Label("Security Answer :");
		gridPane.add(securityAnswerLabel, 0, 11);
		TextField securityAnswerField = new TextField();
		securityAnswerField.setPrefHeight(40);
		gridPane.add(securityAnswerField, 1, 11);

		// Add Register Button
		Button submitButton = new Button("Register");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 12, 2, 1);
		GridPane.setHalignment(submitButton, HPos.CENTER);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
		
        submitButton.setOnAction(e -> {
			LoginScreen login = new LoginScreen();
			try {
				LoginScreen.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
        
        
        // ADD ALERT BOX FOR PASSWORD REQUIREMENTS HERE 
        
        
        
        
        
        
        
        
		
		// Add Forgot password button
				Button forgotPasswordButton = new Button("Forgot Password");
				forgotPasswordButton.setPrefHeight(40);
				forgotPasswordButton.setDefaultButton(true);
				forgotPasswordButton.setPrefWidth(100);
				gridPane.add(forgotPasswordButton, 0, 13, 2, 1);
				GridPane.setHalignment(forgotPasswordButton, HPos.CENTER);
				GridPane.setMargin(forgotPasswordButton, new Insets(20, 0, 20, 0));
				
		        forgotPasswordButton.setOnAction(e -> {
					Login ForgotPassword = new Login();
					try {
						.start(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				});
				
	
				

	

	}

	public static void main(String[] args) {
		launch(args);
	}
	

		
	}

