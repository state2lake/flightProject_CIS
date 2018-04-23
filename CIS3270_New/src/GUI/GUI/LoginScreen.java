package GUI;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class LoginScreen extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
	
	

    @Override
    public void start(Stage primaryStage) {
    	
    	//Create Pane
        primaryStage.setTitle("Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome to Flight Master");
        scenetitle.setFont(Font.font("family", FontWeight.BOLD, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        
        //Create label and text field for user name
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //Create label and text field for password
        Label password = new Label("Password:");
        grid.add(password, 0, 2);
        PasswordField passBox = new PasswordField();
        grid.add(passBox, 1, 2);
        
        
        //Create login button
        Button loginButton = new Button("Find my flight!");
        HBox hbloginButton = new HBox(10);
        hbloginButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbloginButton.getChildren().add(loginButton);
        grid.add(hbloginButton, 1, 4);
        
        loginButton.setOnAction(e -> {
			Login Main = new Login();
			try {
				.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

        
        
        //Create register button
        Button registerButton = new Button("New User");
        HBox hbregisterButton = new HBox(10);
        hbregisterButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbregisterButton.getChildren().add(registerButton);
        grid.add(hbregisterButton, 1, 5);



        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

