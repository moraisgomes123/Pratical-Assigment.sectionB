package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.HotelBookingSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelBookingSystemTest {
    private Room[] rooms;
// Assisted by DeepSeek AI for structure and implementation guidance
    @BeforeEach
    public void setUp() {
        rooms = new Room[3];
        rooms[0] = new SingleRoom(101);
        rooms[1] = new DoubleRoom(201);
        rooms[2] = new SuiteRoom(301);
    }
// Assisted by DeepSeek AI for structure and implementation guidance
    @Test
    public void testBookRoomSuccessfully() {
        HotelBookingSystem.bookRoom(rooms, 101, "Alice");
        assertTrue(rooms[0].isBooked());
        assertEquals("Alice", rooms[0].getCustomerName());
    }

    @Test
    public void testBookAlreadyBookedRoom() {
        HotelBookingSystem.bookRoom(rooms, 201, "Bob");
        HotelBookingSystem.bookRoom(rooms, 201, "Charlie");
        assertEquals("Bob", rooms[1].getCustomerName(), "Booking should not overwrite existing customer");
    }
// Assisted by DeepSeek AI for structure and implementation guidance
    @Test
    public void testCancelBooking() {
        HotelBookingSystem.bookRoom(rooms, 301, "David");
        HotelBookingSystem.cancelBooking(rooms, 301);
        assertFalse(rooms[2].isBooked());
        assertEquals("", rooms[2].getCustomerName());
    }

    @Test
    public void testCancelNotBookedRoom() {
        HotelBookingSystem.cancelBooking(rooms, 101);
        assertFalse(rooms[0].isBooked(), "Room should remain unbooked");
    }

    @Test
    public void testBookNonExistentRoom() {
        assertDoesNotThrow(() -> HotelBookingSystem.bookRoom(rooms, 999, "Eve"));
    }
}
