package org.example;

import java.util.Scanner;

public class HotelBookingSystem {
    public static void main(String[] args) {
        // creating an array
        Room[] rooms = new Room[6];
        rooms[0] = new SingleRoom(101);
        rooms[1] = new SingleRoom(102);
        rooms[2] = new DoubleRoom(201);
        rooms[3] = new DoubleRoom(202);
        rooms[4] = new SuiteRoom(301);
        rooms[5] = new SuiteRoom(302);

        Scanner scanner = new Scanner(System.in);
        int choice;

        // This loop keeps running until the user chooses option 4 (Exit).
        do {
            System.out.println("\n--- Hotel Booking System ---");
            System.out.println("1. Display Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Menu handling
            switch (choice) {
                case 1:
                    displayRooms(rooms);
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    bookRoom(rooms, roomNum, name);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelNum = scanner.nextInt();
                    cancelBooking(rooms, cancelNum);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Displays all rooms with their number, type, and either the customer’s name or "Available".
    public static void displayRooms(Room[] rooms) {
        System.out.println("\nRoom Report:");
        System.out.printf("%-10s %-10s %-20s\n", "Room No", "Type", "Customer");
        for (Room r : rooms) {
            if (r != null) {
                System.out.printf("%-10d %-10s %-20s\n",
                        r.getRoomNumber(),
                        r.getRoomType(),
                        r.isBooked() ? r.getCustomerName() : "Available");
            }
        }
    }

    // Books a room if it exists and is not already booked.
    public static void bookRoom(Room[] rooms, int roomNumber, String customerName) {
        for (Room r : rooms) {
            if (r != null && r.getRoomNumber() == roomNumber) {
                if (!r.isBooked()) {
                    r.bookRoom(customerName);
                    System.out.println("Room booked successfully!");
                } else {
                    System.out.println("Room is already booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    // Cancels a booking if the room exists and is currently booked.
    public static void cancelBooking(Room[] rooms, int roomNumber) {
        for (Room r : rooms) {
            if (r != null && r.getRoomNumber() == roomNumber) {
                if (r.isBooked()) {
                    r.cancelBooking();
                    System.out.println("Booking canceled successfully!");
                } else {
                    System.out.println("Room is not booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }
}

