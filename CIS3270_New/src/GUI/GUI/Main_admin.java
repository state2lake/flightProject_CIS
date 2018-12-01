package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class Main_admin extends Application {

    Stage window;
    TableView<Flight> table;
    TextField flightsBooked, searchField,TflightId,TdepartureDate,TarrivalDate,
    TdepartureTime,TarrivalTime,TdepartureCity, TarrivalCity,TflightNumber,Tprice,
    TmaxSeats,TcurrentSeats;
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
        Label LflightId = new Label("Flight ID:");
        Label LdepartureDate = new Label("Departure Date:");
        Label LArrivalDate = new Label("Arrival Date:");
        Label LDepartureTime = new Label("Departure Time:");
        Label LArrivalTime = new Label("Arrival Time:");
        Label LDepartureCity = new Label("Departure City:");
        Label LArrivalCity = new Label("Arrival City:");
        Label LFlightNumber = new Label("Flight Number:");
        Label LPrice = new Label("Price:");
        Label LMaxSeats =  new Label("Max Seats:");
        Label LCurrentSeats = new Label("Current Seats:");
        
    	
    	searchOptions.setValue("Choose option");

        
        searchField = new TextField();
        searchField.setMaxWidth(100);
       
        
        flightsBooked = new TextField();     
        flightsBooked.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        flightsBooked.setPromptText(Integer.toString(booknum));      
        flightsBooked.setMaxWidth(30);        
        flightsBooked.setEditable(false);
        
        
       /* TflightId,TdepartureDate,TarrivalDate,
        TdepartureTime,TarrivalTime,TdepartureCity, TarrivalCity,TflightNumber,Tprice,  
        TmaxSeats,TcurrentSeats*/
        
        TflightId = new TextField();
        TflightId.setMaxWidth(40);
        
        TdepartureDate = new TextField();
        TdepartureDate.setMaxWidth(80);
        
        TarrivalDate = new TextField();
        TarrivalDate.setMaxWidth(80);
        
        
        TdepartureTime = new TextField();
        TdepartureTime.setMaxWidth(80);
        
        TarrivalTime = new TextField();
        TarrivalTime.setMaxWidth(80);
        
        TdepartureCity = new TextField();
        TdepartureCity.setMaxWidth(80);
        
        TarrivalCity = new TextField();
        TarrivalCity.setMaxWidth(80);
        
        TflightNumber = new TextField();
        TflightNumber.setMaxWidth(80);
        
        Tprice = new TextField();
        Tprice.setMaxWidth(80);
        
        TmaxSeats = new TextField();
        TmaxSeats.setMaxWidth(80);
        
        TcurrentSeats = new TextField();
        TcurrentSeats.setMaxWidth(80);

        //Button

        Button bookButton = new Button("Book");

        bookButton.setOnAction(e -> bookButtonClicked());

        Button unbookButton = new Button("Unbook");

        unbookButton.setOnAction(e -> unbookButtonClicked());

        Button removeButton = new Button("Remove");

        removeButton.setOnAction(e -> removeButtonClicked());
        
        Button search = new Button("Search");

        search.setOnAction(e -> searchButtonClicked());

        Button delete = new Button("Delete selected flight");

        delete.setOnAction(e -> deleteButtonClicked());
        
        Button add= new Button("Add new flight");

        add.setOnAction(e -> addButtonClicked());


        HBox hBox = new HBox();

        hBox.setPadding(new Insets(15,10,10,280));

        hBox.setSpacing(10);

        hBox.getChildren().addAll(searchFlight,searchOptions,searchField,search,bookButton, unbookButton,removeButton, booked,flightsBooked);

        
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(LflightId,TflightId,LdepartureDate,TdepartureDate,
        		LArrivalDate,TarrivalDate,LDepartureTime,TdepartureTime,LArrivalTime,TarrivalTime,LDepartureCity,TdepartureCity);
        hBox1.setPadding(new Insets(0,0,10,10));
        hBox1.setSpacing(5);
        
        
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(LArrivalCity,TarrivalCity,LFlightNumber,TflightNumber,
        		LPrice,Tprice,LMaxSeats,TmaxSeats,LCurrentSeats,TcurrentSeats);
        hBox2.setPadding(new Insets(0,0,10,10));
        hBox2.setSpacing(5);
        
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(add,delete);
        hBox3.setPadding(new Insets(0,0,10,750));
        hBox3.setSpacing(15);
        
        VBox vBox = new VBox();

        vBox.getChildren().addAll(table, hBox,hBox1,hBox2,hBox3);


        Scene scene = new Scene(vBox);

        window.setScene(scene);

        window.show();

    }



	private Object addButtonClicked() {
		// TODO Auto-generated method stub
		return null;
	}


	private void deleteButtonClicked() {
		
		ObservableList<Flight> flights = FXCollections.observableArrayList();
		Flight selectedFlight = table.getSelectionModel().getSelectedItem();
		
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CIS3270\", \"root\", \"Tsiknus41");
		
		String query = "DELETE FROM Flight WHERE flightId="+selectedFlight.getFlightId();

		// create a statement

		PreparedStatement myStat = myConn.prepareStatement(query);

		// execute a query

		myStat.executeUpdate();
		

		String query1 = "select * from flight";
		PreparedStatement myStat1 = myConn.prepareStatement(query1);
		ResultSet rs1;
		rs1 = myStat1.executeQuery();

		while (rs1.next()) {

				flights.add(
						new Flight(
						rs1.getInt("flightId"),
						rs1.getString("departureDate"),
						rs1.getString("arrivalDate"),
						rs1.getString("departureTime"),
						rs1.getString("arrivalTime"),
						rs1.getString("departureCity"),
						rs1.getString("arrivalCity"),
						rs1.getString("flightNum"),
						rs1.getString("price"),
						rs1.getInt("maxPassengers"),
						rs1.getInt("currentPassengers")
						));

			table.setItems(flights);

		}

		myStat.close();

		rs1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
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





}