package model.dto;

/**
 * Represents a payment dto.
 */
public class PaymentDto {
    private int roomId;
    private double price;
    private int guestId;

    /**
     * Creates a payment dto without params.
     */
    public PaymentDto() {
    }

    /**
     * Creates a payment dto with the specified roomId, price, guestId.
     *
     * @param roomId  The payment dto's roomId.
     * @param price   The payment dto's price.
     * @param guestId The payment dto's guestId.
     */
    public PaymentDto(int roomId, double price, int guestId) {
        this.roomId = roomId;
        this.price = price;
        this.guestId = guestId;
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
     * Gets the value of {@link #guestId}.
     *
     * @return the value of {@link #guestId}.
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * This is a setter which sets the guestId
     *
     * @param guestId - the guestId to be set
     */
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
