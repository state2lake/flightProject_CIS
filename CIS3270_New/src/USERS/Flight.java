package USERS;

	public class Flight {

		private int flightId;

		private String departureDate;

		private String arrivalDate;

		private String departureCity;

		private String arrivalCity;

		private String flightNum;

		private String price;

		private int maxPassengers;

		private int currentPassengers;

		private boolean isFull;
		
		private String departureTime;
		
		private String arrivalTime;




		public Flight(int flightId, String departureDate, String arrivalDate,String departureTime, String arrivalTime,

				String departureCity, String arrivalCity, String flightNum,

				String price, int maxPassengers, int currentPassengers) {

			this.flightId = flightId;
			
			this.departureDate = departureDate;

			this.arrivalDate = arrivalDate;

			this.departureCity = departureCity;

			this.arrivalCity = arrivalCity;

			this.flightNum = flightNum;

			this.price = price;

			this.maxPassengers = maxPassengers;

			this.currentPassengers = currentPassengers;
			
			this.departureTime = departureTime;
			
			this.arrivalTime = arrivalTime;

		}



		public int getFlightId() {

			return flightId;

		}



		public void setFlightId(int flightId) {

			this.flightId = flightId;

		}



		public String getDepartureDate() {

			return departureDate;

		}



		public void setDepartureDate(String departureDate) {

			this.departureDate = departureDate;

		}



		public String getArrivalDate() {

			return arrivalDate;

		}



		public void setArrivalDate(String arrivalDate) {

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



		public String getDepartureTime() {
			return departureTime;
		}



		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}



		public String getArrivalTime() {
			return arrivalTime;
		}



		public void setArrivalTime(String arrivalTime) {
			this.arrivalTime = arrivalTime;
		}






	}

