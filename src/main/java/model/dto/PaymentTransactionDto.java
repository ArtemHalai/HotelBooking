package model.dto;

/**
 * Represents a payment transaction dto.
 */
public class PaymentTransactionDto {
    private int roomId;
    private double price;
    private String username;
    private int reservationId;

    /**
     * Creates a payment transaction dto without params.
     */
    public PaymentTransactionDto() {
    }

    /**
     * Creates a payment transaction dto with the specified roomId, price, username, reservationId.
     *
     * @param roomId        The payment transaction dto's roomId.
     * @param price         The payment transaction dto's price.
     * @param username      payment transaction dto's username.
     * @param reservationId The payment transaction dto's reservationId.
     */
    public PaymentTransactionDto(int roomId, double price, String username, int reservationId) {
        this.roomId = roomId;
        this.price = price;
        this.username = username;
        this.reservationId = reservationId;
    }

    /**
     * Gets the value of {@link #roomId}.
     *
     * @return the value of {@link #roomId}.
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * This is a setter which sets the roomId
     *
     * @param roomId - the roomId to be set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Gets the value of {@link #price}.
     *
     * @return the value of {@link #price}.
     */
    public double getPrice() {
        return price;
    }

    /**
     * This is a setter which sets the price
     *
     * @param price - the price to be set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the value of {@link #username}.
     *
     * @return the value of {@link #username}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is a setter which sets the username
     *
     * @param username - the username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the value of {@link #reservationId}.
     *
     * @return the value of {@link #reservationId}.
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * This is a setter which sets the reservationId
     *
     * @param reservationId - the reservationId to be set
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
