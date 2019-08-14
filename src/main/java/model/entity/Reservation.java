package model.entity;

import java.sql.Date;

/**
 * Represents a reservation.
 */
public class Reservation {
    private int id;
    private Date dateIn;
    private Date dateOut;
    private int guestId;
    private int roomId;

    /**
     * Creates a reservation without params.
     */
    public Reservation() {
    }

    /**
     * Creates a reservation with the specified dateIn, dateOut, roomId.
     *
     * @param roomId  The reservation’s roomId.
     * @param dateIn  The reservation’s dateIn.
     * @param dateOut The reservation’s dateOut.
     */
    public Reservation(Date dateIn, Date dateOut, int roomId) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomId = roomId;
    }

    /**
     * Creates a reservation with the specified id, dateIn, dateOut, guestId, roomId.
     *
     * @param id  The reservation’s id.
     * @param guestId  The reservation’s guestId.
     * @param roomId  The reservation’s roomId.
     * @param dateIn  The reservation’s dateIn.
     * @param dateOut The reservation’s dateOut.
     */
    public Reservation(int id, Date dateIn, Date dateOut, int guestId, int roomId) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.guestId = guestId;
        this.roomId = roomId;
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
     * Gets the value of {@link #dateIn}.
     *
     * @return the value of {@link #dateIn}.
     */
    public Date getDateIn() {
        return dateIn;
    }

    /**
     * This is a setter which sets the dateIn
     *
     * @param dateIn - the dateIn to be set
     */
    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * Gets the value of {@link #dateOut}.
     *
     * @return the value of {@link #dateOut}.
     */
    public Date getDateOut() {
        return dateOut;
    }

    /**
     * This is a setter which sets the dateOut
     *
     * @param dateOut - the dateOut to be set
     */
    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
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
