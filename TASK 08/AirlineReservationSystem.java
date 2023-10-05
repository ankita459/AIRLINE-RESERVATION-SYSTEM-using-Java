import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String pickUpLocation;
    private String destination;
    private String timing;
    private int availableSeats;

    public Flight(String flightNumber, String pickUpLocation, String destination, String timing, int availableSeats) {
        this.flightNumber = flightNumber;
        this.pickUpLocation = pickUpLocation;
        this.destination = destination;
        this.timing = timing;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDestination() {
        return destination;
    }

    public String getTiming() {
        return timing;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + ": " + pickUpLocation + " to " + destination + " (Timing: " + timing
                + ", Available Seats: " + availableSeats + ")";
    }
}

class FlightSearch {
    public List<Flight> searchFlights(String pickUpLocation, String destination, String timing, int availableSeats) {
        // Simulate fetching flight data from globally distributed systems
        List<Flight> flights = new ArrayList<>();

        // Add sample flights
        flights.add(new Flight("ABC123", "New York", "Los Angeles", "10:00 AM", 5));
        flights.add(new Flight("DEF456", "London", "Paris", "12:00 PM", 3));
        flights.add(new Flight("GHI789", "Tokyo", "Sydney", "02:00 PM", 7));

        // You can customize this logic to filter flights based on the provided
        // parameters

        return flights;
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        // Create an instance of FlightSearch
        FlightSearch flightSearch = new FlightSearch();

        // Perform a flight search
        List<Flight> searchResults = flightSearch.searchFlights("New York", "Los Angeles", "10:00 AM", 2);

        // Display the search results
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println("Flight " + (i + 1) + ": " + searchResults.get(i));
        }

        // Ask the customer to choose a flight
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a flight (enter the flight number): ");
        String flightChoice = scanner.nextLine();

        // Validate the flight choice
        Flight chosenFlight = null;
        for (Flight flight : searchResults) {
            if (flight.getFlightNumber().equals(flightChoice)) {
                chosenFlight = flight;
                break;
            }
        }

        if (chosenFlight == null) {
            System.out.println("Invalid flight choice. Please try again.");
            return;
        }

        // Ask the customer for payment details
        System.out.print("Enter your email: ");
        String paymentDetails = scanner.next();

        // Process the payment
        boolean paymentSuccessful = processPayment(paymentDetails);

        // Book the ticket if payment is successful
        if (paymentSuccessful) {
            bookTicket(chosenFlight);
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Payment failed. Ticket not booked.");
        }
    }

    // Method to process the payment
    private static boolean processPayment(String paymentDetails) {
        // Code to process the payment
        // Return true if payment is successful, false otherwise
        // Example implementation:
        if (paymentDetails != null && !paymentDetails.isEmpty()) {
            // Process the payment logic here
            // For example, you can check if the paymentDetails are valid and payment is
            // successful
            return true; // Payment successful
        } else {
            return false; // Payment failed
        }
    }

    // Method to book the ticket
    private static void bookTicket(Flight flight) {
        // Code to book the ticket
        // Example implementation:
        System.out.println("Ticket booked for Flight " + flight.getFlightNumber() + ": " + flight.getPickUpLocation()
                + " to " + flight.getDestination() + " (Timing: " + flight.getTiming() + ", Available Seats: "
                + flight.getAvailableSeats() + ")");
    }
}