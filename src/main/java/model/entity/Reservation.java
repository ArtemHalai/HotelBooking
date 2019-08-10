package model.entity;

import java.sql.Date;

public class Reservation {
    private int id;
    private Date dateIn;
    private Date dateOut;
    private int guestId;
    private int roomId;

    public Reservation() {
    }

    public Reservation(Date dateIn, Date dateOut, int roomId) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomId = roomId;
    }

    public Reservation(int id, Date dateIn, Date dateOut, int guestId, int roomId) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.guestId = guestId;
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }
}
