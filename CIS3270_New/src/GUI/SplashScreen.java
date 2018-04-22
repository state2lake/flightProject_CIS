package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class SplashScreen {
	

public static class ShowImage extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	  
	  
    // Create a pane 
    Pane pane = new HBox(10);
    pane.setPadding(new Insets(100));
    
    //Insert image into the pane
    Image image = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRONV99IsFO1V8zvO22AvTIY50Grj-pmO6lBD4cNDPu9XkBfyKX-Q");
    pane.getChildren().add(new ImageView(image));
   
  
    
    // Create a scene 
    Scene scene = new Scene(pane);
    
    // Name Title
    primaryStage.setTitle("Welcome"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
  }
  

  public static void main(String[] args) {
    launch(args);
  }
}

}
