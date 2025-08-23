package org.example;

public class Room {
    private int roomNumber;
    private boolean isBooked;
    private String customerName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.customerName = "";
    }

    // Getters and setters (information hiding)
    public int getRoomNumber() { return roomNumber; }
    public boolean isBooked() { return isBooked; }
    public void bookRoom(String customerName) {
        this.isBooked = true;
        this.customerName = customerName;
    }
    public void cancelBooking() {
        this.isBooked = false;
        this.customerName = "";
    }
    public String getCustomerName() { return customerName; }

    public String getRoomType() {
        return "Standard";
    }
}
