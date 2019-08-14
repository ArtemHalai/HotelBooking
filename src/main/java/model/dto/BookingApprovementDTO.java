package model.dto;

/**
 * Represents a booking approvement.
 */
public class BookingApprovementDTO {
    private int reservationId;
    private int roomId;
    private double price;

    /**
     * Creates a booking approvement with the specified reservationId, roomId, price.
     *
     * @param reservationId The booking approvement's reservationId.
     * @param roomId        The booking approvement's roomId.
     * @param price         The booking approvement's price.
     */
    public BookingApprovementDTO(int reservationId, int roomId, double price) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.price = price;
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
}
