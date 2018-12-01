package GUI;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import USERS.Customer;
import USERS.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Main extends Application {

    Stage window;
    TableView<Flight> table;
    TextField flightsBooked, searchField;
    int booknum = 0;
    ObservableList<String> options = 
    	    FXCollections.observableArrayList(
    	    		"Flight ID",

    				"Arrival City", "Flight Number",

    				"Depature City"
    	    );
    	final ComboBox searchOptions = new ComboBox(options);

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Book Flights");

        //Flight ID column
        TableColumn<Flight, String> flightId = new TableColumn<>("Flight ID");
        flightId.setMinWidth(55);
        flightId.setCellValueFactory(new PropertyValueFactory<>("flightId"));

        //Departure Date column
        TableColumn<Flight, Double> departureDate = new TableColumn<>("Departure Date");
        departureDate.setMinWidth(80);
        departureDate.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

        //Arrival Date column
        TableColumn<Flight, String> arrivalDate = new TableColumn<>("Arrival Date");
        arrivalDate.setMinWidth(80);
        arrivalDate.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        
        //Departure Time column
        TableColumn<Flight, Double> departureTime = new TableColumn<>("Departure Time");
        departureTime.setMinWidth(80);
        departureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));


        //Arrival Time column
        TableColumn<Flight, String> arrivalTime = new TableColumn<>("Arrival Time");
        arrivalTime.setMinWidth(80);
        arrivalTime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        
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
        price.setMinWidth(60);
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
        isFull.setMinWidth(48);
        isFull.setCellValueFactory(new PropertyValueFactory<>("isFull"));
        
        table = new TableView<>();

        table.setItems(getFlight());

        table.getColumns().addAll(flightId, departureDate, arrivalDate,departureTime,arrivalTime, 
        		departureCity, arrivalCity,flightNum,price,maxPassengers,currentPassengers,isFull );

        

        
        

        
        Label booked = new Label("Flight Booked:");
        Label searchFlight = new Label("Search Flight by:");
        
    	
    	searchOptions.setValue("Choose option");

        
        searchField = new TextField();
        searchField.setMaxWidth(100);
       
        
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
        
        Button search = new Button("Search");

        search.setOnAction(e -> searchButtonClicked());



        HBox hBox = new HBox();

        hBox.setPadding(new Insets(15,10,10,280));

        hBox.setSpacing(10);

        hBox.getChildren().addAll(searchFlight,searchOptions,searchField,search,bookButton, unbookButton,removeButton, booked,flightsBooked);


        VBox vBox = new VBox();

        vBox.getChildren().addAll(table, hBox);



        Scene scene = new Scene(vBox);

        window.setScene(scene);

        window.show();

    }



	private void searchButtonClicked() {
		
		  ObservableList<Flight> flights = FXCollections.observableArrayList();
		  
		switch(searchOptions.getSelectionModel().getSelectedIndex()) {
		case 0:
			

		        try {

					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270", "root", "Tsiknus41");

					String query = "select * from Flight WHERE flightId="+searchField.getText();

					// create a statement

					PreparedStatement myStat = myConn.prepareStatement(query);

					// execute a query

					ResultSet rs;

					rs = myStat.executeQuery();

					while (rs.next()) {

							flights.add(
									new Flight(
									rs.getInt("flightId"),
									rs.getString("departureDate"),
									rs.getString("arrivalDate"),
									rs.getString("departureTime"),
									rs.getString("arrivalTime"),
									rs.getString("departureCity"),
									rs.getString("arrivalCity"),
									rs.getString("flightNum"),
									rs.getString("price"),
									rs.getInt("maxPassengers"),
									rs.getInt("currentPassengers")
									));

						table.setItems(flights);

					}

					myStat.close();

					rs.close();

				} catch (Exception ex) {



				}
	
			break;
			
		case 1:
			
			
			  try {

					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270", "root", "Tsiknus41");

					String query = "select * from Flight WHERE arrivalCity='"+searchField.getText()+"'";

					// create a statement

					PreparedStatement myStat = myConn.prepareStatement(query);

					// execute a query

					ResultSet rs;

					rs = myStat.executeQuery();

					while (rs.next()) {

							flights.add(
									new Flight(
									rs.getInt("flightId"),
									rs.getString("departureDate"),
									rs.getString("arrivalDate"),
									rs.getString("departureTime"),
									rs.getString("arrivalTime"),
									rs.getString("departureCity"),
									rs.getString("arrivalCity"),
									rs.getString("flightNum"),
									rs.getString("price"),
									rs.getInt("maxPassengers"),
									rs.getInt("currentPassengers")
									));

						table.setItems(flights);

					}

					myStat.close();

					rs.close();

				} catch (Exception ex) {



				}

			break;
			
			
		case 2: 
			
			
			  try {

					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270", "root", "Tsiknus41");

					String query = "select * from Flight WHERE flightNum='"+searchField.getText()+"'";

					// create a statement

					PreparedStatement myStat = myConn.prepareStatement(query);

					// execute a query

					ResultSet rs;

					rs = myStat.executeQuery();

					while (rs.next()) {

							flights.add(
									new Flight(
									rs.getInt("flightId"),
									rs.getString("departureDate"),
									rs.getString("arrivalDate"),
									rs.getString("departureTime"),
									rs.getString("arrivalTime"),
									rs.getString("departureCity"),
									rs.getString("arrivalCity"),
									rs.getString("flightNum"),
									rs.getString("price"),
									rs.getInt("maxPassengers"),
									rs.getInt("currentPassengers")
									));

						table.setItems(flights);

					}

					myStat.close();

					rs.close();

				} catch (Exception ex) {



				}
			
			break;
		
		case 3:
			
			

			  try {

					Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270", "root", "Tsiknus41");

					String query = "select * from Flight WHERE departureCity='"+searchField.getText()+"'";

					// create a statement

					PreparedStatement myStat = myConn.prepareStatement(query);

					// execute a query

					ResultSet rs;

					rs = myStat.executeQuery();

					while (rs.next()) {

							flights.add(
									new Flight(
									rs.getInt("flightId"),
									rs.getString("departureDate"),
									rs.getString("arrivalDate"),
									rs.getString("departureTime"),
									rs.getString("arrivalTime"),
									rs.getString("departureCity"),
									rs.getString("arrivalCity"),
									rs.getString("flightNum"),
									rs.getString("price"),
									rs.getInt("maxPassengers"),
									rs.getInt("currentPassengers")
									));

						table.setItems(flights);

					}

					myStat.close();

					rs.close();

				} catch (Exception ex) {



				}
			
			break;
		
		default:
			
			new Alert(Alert.AlertType.INFORMATION, "Please select a search option").showAndWait();
			
			searchField.clear();
			
			
			break;
			
		
		}
		
		
	
		
	}


	//Add button clicked

    public void bookButtonClicked(){
    	
    	new Alert(Alert.AlertType.INFORMATION, "Booking successful").showAndWait();
    	
    	booknum++;
    	
    	flightsBooked.setText(Integer.toString(booknum));
    	
    	
        
  

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



    //Get all of the flights

    public ObservableList<Flight> getFlight(){

        ObservableList<Flight> flights = FXCollections.observableArrayList();

        try {



			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270", "root", "Tsiknus41");

			String query = "select * from flight";

			// create a statement

			PreparedStatement myStat = myConn.prepareStatement(query);

			// execute a query

			ResultSet rs;

			rs = myStat.executeQuery();

			while (rs.next()) {

					flights.add(
							new Flight(
							rs.getInt("flightId"),
							rs.getString("departureDate"),
							rs.getString("arrivalDate"),
							rs.getString("departureTime"),
							rs.getString("arrivalTime"),
							rs.getString("departureCity"),
							rs.getString("arrivalCity"),
							rs.getString("flightNum"),
							rs.getString("price"),
							rs.getInt("maxPassengers"),
							rs.getInt("currentPassengers")
							));

				table.setItems(flights);

			}

			myStat.close();

			rs.close();

		} catch (Exception ex) {



		}
        
        
        
        
        return flights;

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


}