package br.ufpa.refactoring.q10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomBookingTest {

    @Test
    void quote_examples() {
        RoomBooking rb = new RoomBooking();

        assertEquals(100.0, rb.quote(request("B", 1, "101", 8, 10, false, false, 10)), 0.001);
        assertEquals((2*50.0 + 30 + 20) * 1.15 + 10, rb.quote(request("A", 3, "101", 8, 10, true, true, 50)), 0.01);
        assertEquals((2*50.0) + 40, rb.quote(request("B", 1, "LAB", 8, 10, false, false, 10)), 0.01);
    }

    private RoomBooking.BookingRequest request(String building, int floor, String room,
                                               int startHour, int endHour,
                                               boolean projector, boolean sound, int attendees) {
        return new RoomBooking.BookingRequest(
                new RoomBooking.Room(building, floor, room),
                new RoomBooking.Schedule(startHour, endHour),
                projector, sound, attendees);
    }
}
