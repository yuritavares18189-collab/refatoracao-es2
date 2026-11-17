package br.ufpa.refactoring.q10;

public class RoomBooking {

    public double quote(BookingRequest request) {
        double base = request.schedule().hours() * 50.0;
        if (request.projector()) base += 30.0;
        if (request.sound()) base += 20.0;
        if (request.attendees() > 40) base *= 1.15;

        Room room = request.room();
        if ("A".equals(room.building()) && room.floor() >= 3) base += 10.0;
        if ("LAB".equals(room.code())) base += 40.0;

        return Math.round(base * 100.0) / 100.0;
    }

    public record Room(String building, int floor, String code) {}

    public record Schedule(int startHour, int endHour) {
        public int hours() {
            return endHour - startHour;
        }
    }

    public record BookingRequest(Room room, Schedule schedule,
                                 boolean projector, boolean sound, int attendees) {}
}
