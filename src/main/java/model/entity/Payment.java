package model.entity;

import java.sql.Date;

/**
 * Represents a payment.
 */
public class Payment {
    private int id;
    private int roomId;
    private double amount;
    private int guestId;
    private Date paymentDate;

    /**
     * Creates a payment without params.
     */
    public Payment() {
    }

    /**
     * Creates a payment with the specified roomId, amount, paymentDate, guestId.
     *
     * @param roomId      The payment’s roomId.
     * @param amount      The payment’s amount.
     * @param paymentDate The payment’s date.
     * @param guestId     The payment’s guestId.
     */
    public Payment(int roomId, double amount, Date paymentDate, int guestId) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    /**
     * Creates a payment with the specified id, roomId, amount, paymentDate, guestId.
     *
     * @param id          The payment’s id.
     * @param roomId      The payment’s roomId.
     * @param amount      The payment’s amount.
     * @param paymentDate The payment’s date.
     * @param guestId     The payment’s guestId.
     */
    public Payment(int id, int roomId, double amount, Date paymentDate, int guestId) {
        this.guestId = guestId;
        this.id = id;
        this.roomId = roomId;
        this.amount = amount;
        this.paymentDate = paymentDate;
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

    /**
     * Gets the value of {@link #id}.
     *
     * @return the value of {@link #id}.
     */
    public int getId() {
        return id;
    }

    /**
     * This is a setter which sets the id
     *
     * @param id - the id to be set
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets the value of {@link #amount}.
     *
     * @return the value of {@link #amount}.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * This is a setter which sets the amount
     *
     * @param amount - the amount to be set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the value of {@link #paymentDate}.
     *
     * @return the value of {@link #paymentDate}.
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * This is a setter which sets the paymentDate
     *
     * @param paymentDate - the paymentDate to be set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
