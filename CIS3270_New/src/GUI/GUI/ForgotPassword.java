package GUI;

import java.sql.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ForgotPassword extends Application  {
	
	public static void main(String[] args) {

		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Password Recovery");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);
		
		//Create a header
		Label forgotPassword = new Label("Recover Your Password");
		grid.setAlignment(Pos.TOP_CENTER);
		GridPane.setHalignment(forgotPassword, HPos.CENTER);
		
		// Create label and text field
		Label userNameLabel = new Label("Enter Your Username Below");
		GridPane.setConstraints(userNameLabel, 1, 1);
		grid.setAlignment(Pos.TOP_CENTER);


		TextField userNameField = new TextField();
		GridPane.setConstraints(userNameField, 1, 2);
		grid.setAlignment(Pos.CENTER);

		//Button to recover password 
		Button recoverPassword = new Button("Recover Password");
		GridPane.setConstraints(recoverPassword, 1, 4);
		recoverPassword.setOnAction(e -> {
			
			
			
			
			
			
			
			
		//Button to return to login page
			Button returnToLoginButton = new Button("Return To Log In");
			GridPane.setConstraints(returnToLoginButton, 1, 5);
	        returnToLoginButton.setOnAction(e -> {
				Login LoginScreen = new Login();
				try {
					.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			});
	

}
	}
}

