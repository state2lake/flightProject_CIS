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
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginScreen extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		// Create Pane
		primaryStage.setTitle("Welcome");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Welcome to Flight Master");
		scenetitle.setFont(Font.font("family", FontWeight.BOLD, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		// Create label and text field for user name
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		TextField userTextField = new TextField();

		grid.add(userTextField, 1, 1);

		// Create label and text field for password
		Label password = new Label("Password:");
		grid.add(password, 0, 2);
		PasswordField passBox = new PasswordField();
		grid.add(passBox, 1, 2);

		// Create login button
		Button loginButton = new Button("Find my flight!");
		HBox hbloginButton = new HBox(10);
		hbloginButton.setAlignment(Pos.BOTTOM_RIGHT);
		hbloginButton.getChildren().add(loginButton);
		grid.add(hbloginButton, 1, 4);

		loginButton.setOnAction(e -> {
			Main main = new Main();

			try {

				// maybe put an arraylist in to add all the passwords to
				checkUsername(userTextField, primaryStage);
				checkPassword(passBox, primaryStage);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}

		});

		// Create register button
		Button registerButton = new Button("New User");
		HBox hbregisterButton = new HBox(10);
		hbregisterButton.setAlignment(Pos.BOTTOM_RIGHT);
		hbregisterButton.getChildren().add(registerButton);
		grid.add(hbregisterButton, 1, 5);
		Scene scene = new Scene(grid, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

		registerButton.setOnAction(e -> {
			RegistrationScreen screen = new RegistrationScreen();
			try {
				screen.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Button forgotPasswordButton = new Button("Forgot Password");
		HBox forgotPassword = new HBox(10);
		forgotPassword.setAlignment(Pos.BOTTOM_RIGHT);
		forgotPassword.getChildren().add(forgotPasswordButton);
		grid.add(forgotPassword, 1, 6);
		
		forgotPasswordButton.setOnAction(e -> {
			ForgotPassword fPScreen = new ForgotPassword();
			try { 
				fPScreen.start(primaryStage);
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		});
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

	public static void checkUsername(TextField user, Stage primaryStage) {
		Main main = new Main();

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		try {
			dbConnection = Connect();
			String sql = "SELECT userNAME FROM Customer";
			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();
			ResultSet rsp = preparedStatement.executeQuery();

			while (rs.next() && rsp.next()) {

				String username = rs.getString("userNAME");

				System.out.println(username);
				ArrayList<String> list = new ArrayList<>();
				list.add(rs.getString("userNAME"));

				System.out.println(list);

				if (user.getText().equals(rs.getString("userNAME"))) {

					System.out.println(list);
					main.start(primaryStage);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void checkPassword(PasswordField pass, Stage primaryStage) {
		Main main = new Main();

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		try {
			dbConnection = Connect();
			String sql = "SELECT passWord FROM Customer";
			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String password = rs.getString("passWord");

				System.out.println(password);
				ArrayList<String> list = new ArrayList<>();
				list.add(rs.getString("passWord"));

				System.out.println(list);

				if (pass.getText().equals(rs.getString("passWord"))) {

					System.out.println(list);
					main.start(primaryStage);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}