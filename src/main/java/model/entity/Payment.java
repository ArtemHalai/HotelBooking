package model.entity;

import java.sql.Date;

public class Payment {
    private int id;
    private int roomId;
    private double amount;
    private int guestId;
    private Date paymentDate;

    public Payment() {
    }

    public Payment(int roomId, double amount, Date paymentDate, int guestId) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment(int id, int roomId, double amount, Date paymentDate, int guestId) {
        this.guestId = guestId;
        this.id = id;
        this.roomId = roomId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
