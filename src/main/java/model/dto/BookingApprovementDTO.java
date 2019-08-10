package model.dto;

public class BookingApprovementDTO {
    private int reservationId;
    private int roomId;
    private double price;

    public BookingApprovementDTO(int reservationId, int roomId, double price) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
