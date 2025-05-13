package collection_Day3;

import java.util.*;


class Booking {
    String name;
    String flightNumber;

    public Booking(String name, String flightNumber) {
        this.name = name;
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Flight: " + flightNumber;
    }
}

public class Q13_FlightBookingManager {

    // to manage booking requests (FIFO)
    Queue<Booking> bookingRequests = new LinkedList<>();

    // store confirmed bookings with seat numbers
    Map<String, Integer> confirmedBookings = new HashMap<>();
    private int seatNumber = 1;  // Variable to assign seat numbers


    public void addBookingRequest(Booking booking) {
        bookingRequests.add(booking);
    }


    public void processBookings() {
        while (!bookingRequests.isEmpty()) {
            // Get the next booking request from the queue
            Booking currentBooking = bookingRequests.poll();

            // Assign a seat number and confirm the booking
            confirmedBookings.put(currentBooking.toString(), seatNumber);
            System.out.println("Booking confirmed for: " + currentBooking + " | Seat Number: " + seatNumber);

            // Increment the seat number for the next booking
            seatNumber++;
        }
    }


    public void displayConfirmedBookings() {
        System.out.println("\nAll Confirmed Bookings:");
        for (Map.Entry<String, Integer> entry : confirmedBookings.entrySet()) {
            System.out.println(entry.getKey() + " | Seat Number: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Q13_FlightBookingManager manager = new Q13_FlightBookingManager();


        manager.addBookingRequest(new Booking("Alice", "FL001"));
        manager.addBookingRequest(new Booking("Bob", "FL002"));
        manager.addBookingRequest(new Booking("Carol", "FL003"));


        manager.processBookings();

        manager.displayConfirmedBookings();
    }
}
