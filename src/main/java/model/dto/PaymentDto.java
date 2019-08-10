package model.dto;

public class PaymentDto {
    private int roomId;
    private double price;
    private int guestId;

    public PaymentDto() {
    }

    public PaymentDto(int roomId, double price, int guestId) {
        this.roomId = roomId;
        this.price = price;
        this.guestId = guestId;
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

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
