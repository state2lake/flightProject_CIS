	import javafx.application.Application;
	import java.sql.Date;

	public class Flight {

		
		private int flightId;
		private Date departureDate;
		private Date arrivalDate;
		private String departureCity;
		private String arrivalCity;
		private String flightNum;
		private String price;
		private int maxPassengers;
		private int currentPassengers;
		private boolean isFull;

		public Flight(Date departureDate, Date arrivalDate,
				String departureCity, String arrivalCity, String flightNum,
				String price, int max_passengers) {
			super();
			this.departureDate = departureDate;
			this.arrivalDate = arrivalDate;
			this.departureCity = departureCity;
			this.arrivalCity = arrivalCity;
			this.flightNum = flightNum;
			this.price = price;
			this.maxPassengers = maxPassengers;
			this.currentPassengers = currentPassengers;
		}

		public int getFlightId() {
			return flightId;
		}

		public void setFlightId(int flightId) {
			this.flightId = flightId;
		}

		public Date getDepartureDate() {
			return departureDate;
		}

		public void setDepartureDate(Date departureDate) {
			this.departureDate = departureDate;
		}

		public Date getArrivalDate() {
			return arrivalDate;
		}

		public void setArrivalDate(Date arrivalDate) {
			this.arrivalDate = arrivalDate;
		}

		public String getDepartureCity() {
			return departureCity;
		}

		public void setDepartureCity(String departureCity) {
			this.departureCity = departureCity;
		}

		public String getArrivalCity() {
			return arrivalCity;
		}

		public void setArrivalCity(String arrivalCity) {
			this.arrivalCity = arrivalCity;
		}

		public String getFlightNum() {
			return flightNum;
		}

		public void setFlightNum(String flightNum) {
			this.flightNum = flightNum;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public int getMaxPassengers() {
			return maxPassengers;
		}

		public void setMaxPassengers(int maxPassengers) {
			this.maxPassengers = maxPassengers;
		}

		public int getCurrentPassengers() {
			return currentPassengers;
		}

		public void setCurrentPassengers(int currentPassengers) {
			this.currentPassengers = currentPassengers;
		}

		public boolean isFull() {
			return isFull;
		}

		public void setFull(boolean isFull) {
			this.isFull = isFull;
		}

		public static void main(String[] args) {

		}

	}



