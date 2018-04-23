import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Main extends Application {

    Stage window;
    TableView<Flight> table;
    TextField flightsBooked;
    int booknum = 0;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Book Flights");

        //Flight ID column
        TableColumn<Flight, String> flightId = new TableColumn<>("Flight ID");
        flightId.setMinWidth(80);
        flightId.setCellValueFactory(new PropertyValueFactory<>("flightId"));

        //Departure Date column
        TableColumn<Flight, Double> departureDate = new TableColumn<>("Departure Date");
        departureDate.setMinWidth(130);
        departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));



        //Arrival Date column
        TableColumn<Flight, String> arrivalDate = new TableColumn<>("Arrival Date");
        arrivalDate.setMinWidth(130);
        arrivalDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        
        //Departure City column
        TableColumn<Flight, String> departureCity = new TableColumn<>("Departure City");
        departureCity.setMinWidth(100);
        departureCity.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
        
        //Arrival City column
        TableColumn<Flight, String> arrivalCity = new TableColumn<>("Arrival City");
        arrivalCity.setMinWidth(100);
        arrivalCity.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
        
        //Flight Number Column
        TableColumn<Flight, String> flightNum = new TableColumn<>("Flight Number");
        flightNum.setMinWidth(80);
        flightNum.setCellValueFactory(new PropertyValueFactory<>("flightNum"));

        //Price Column
        TableColumn<Flight, String> price = new TableColumn<>("Price");
        price.setMinWidth(80);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Max Passenger column
        TableColumn<Flight, String> maxPassengers = new TableColumn<>("Max Seats");
        maxPassengers.setMinWidth(80);
        maxPassengers.setCellValueFactory(new PropertyValueFactory<>("maxPassengers"));

        //Current Passenger Column
        TableColumn<Flight, String> currentPassengers = new TableColumn<>("Seats Filled");
        currentPassengers.setMinWidth(80);
        currentPassengers.setCellValueFactory(new PropertyValueFactory<>("currentPassengers"));
        
        TableColumn<Flight, String> isFull = new TableColumn<>("Full");
        isFull.setMinWidth(63);
        isFull.setCellValueFactory(new PropertyValueFactory<>("isFull"));
        
        table = new TableView<>();

        table.setItems(getFlight());

        table.getColumns().addAll(flightId, departureDate, arrivalDate, 
        		departureCity, arrivalCity,flightNum,price,maxPassengers,currentPassengers,isFull );

        


        Label booked = new Label("Flight Booked:");
        
        flightsBooked = new TextField();
        
        flightsBooked.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));

        flightsBooked.setPromptText(Integer.toString(booknum));
        
        flightsBooked.setMaxWidth(30);
        
        flightsBooked.setEditable(false);

        //Button

        Button bookButton = new Button("Book");

        bookButton.setOnAction(e -> bookButtonClicked());

        Button unbookButton = new Button("Unbook");

        unbookButton.setOnAction(e -> unbookButtonClicked());

        Button removeButton = new Button("Remove");

        removeButton.setOnAction(e -> removeButtonClicked());



        HBox hBox = new HBox();

        hBox.setPadding(new Insets(15,10,10,620));

        hBox.setSpacing(10);

        hBox.getChildren().addAll(bookButton, unbookButton,removeButton, booked,flightsBooked);


        VBox vBox = new VBox();

        vBox.getChildren().addAll(table, hBox);



        Scene scene = new Scene(vBox);

        window.setScene(scene);

        window.show();

    }



	//Add button clicked

    public void bookButtonClicked(){
    	
    	new Alert(Alert.AlertType.INFORMATION, "Booking successful").showAndWait();
    	
    	booknum++;
    	
    	flightsBooked.setText(Integer.toString(booknum));

        //Product product = new Product();

       // product.setName(nameInput.getText());

        //product.setPrice(Double.parseDouble(priceInput.getText()));

        //product.setQuantity(Integer.parseInt(quantityInput.getText()));

        //table.getItems().add(product);

        //flightsBooked.setText();
        
  

    }



    //Delete button clicked

    public void unbookButtonClicked(){

    	new Alert(Alert.AlertType.INFORMATION, "Flight is unbooked").showAndWait();
    	
    	booknum--;
    	flightsBooked.setText(Integer.toString(booknum));
    	

    }
    
    private void removeButtonClicked() {
		
    	table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    	
	}



    //Get all of the products

    public ObservableList<Flight> getFlight(){

        ObservableList<Flight> products = FXCollections.observableArrayList();

        products.add(new Flight(1,"2018-04-12 11:10AM","2018-04-12 1:30PM","Atlanta","Boston","UA333","$466",200,14));
        products.add(new Flight(2,"2018-04-13 11:10AM","2018-04-13 1:30PM","Atlanta","Boston","UA333","$466",200,14));
        products.add(new Flight(3,"2018-04-14 11:10AM","2018-04-14 1:30PM","Atlanta","Boston","UA333","$466",200,14));
        products.add(new Flight(4,"2018-04-15 11:10AM","2018-04-15 1:30PM","Atlanta","Boston","UA333","$466",200,14));
        products.add(new Flight(5,"2018-04-16 11:10AM","2018-04-16 1:30PM","Atlanta","Boston","UA333","$466",200,14));


        return products;

    }





}