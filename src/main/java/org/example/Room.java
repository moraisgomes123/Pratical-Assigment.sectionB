package org.example;

public class Room {
    private int roomNumber;
    private boolean isBooked;
    private String customerName;

    // Constructor
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.customerName = "";
    }

    //Getters and methods for room management

    public int getRoomNumber() {
        return roomNumber;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void bookRoom(String customerName) {
        this.isBooked = true;
        this.customerName = customerName;
    }

    // Cancels the booking and clears the customer name.
    public void cancelBooking() {
        this.isBooked = false;
        this.customerName = "";
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getRoomType() {
        return "Standard";
    }
}
