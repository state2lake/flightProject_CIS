package GUI;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class AlertBox {
	
	public static void show (String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		
		
		Label label = new Label();
	    label.setText(message);
		label.setTextAlignment(TextAlignment.CENTER);
		
		Button okay = new Button("OK");
		okay.setOnAction(e -> {window.close();});
		VBox layout = new VBox(30);
		layout.getChildren().addAll(label, okay);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene =new Scene(layout,500,100);
		window.setScene(scene);
		window.showAndWait();
		}

	}
