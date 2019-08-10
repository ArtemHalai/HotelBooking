package model.dto;

public class PaymentTransactionDto {
    private int roomId;
    private double price;
    private String username;
    private int reservationId;

    public PaymentTransactionDto() {
    }

    public PaymentTransactionDto(int roomId, double price, String username, int reservationId) {
        this.roomId = roomId;
        this.price = price;
        this.username = username;
        this.reservationId = reservationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
