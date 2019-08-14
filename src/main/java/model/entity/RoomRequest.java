package model.entity;

import java.sql.Date;

/**
 * Represents a room request.
 */
public class RoomRequest {
    private int id;
    private int roomTypeId;
    private Date dateIn;
    private Date dateOut;

    /**
     * Creates a room request with the specified id, roomTypeId, dateIn, dateOut.
     *
     * @param id         The room request’s id.
     * @param roomTypeId The room request’s roomTypeId.
     * @param dateIn     The room request’s dateIn.
     * @param dateOut    The room request’s dateOut.
     */
    public RoomRequest(int id, int roomTypeId, Date dateIn, Date dateOut) {
        this.id = id;
        this.roomTypeId = roomTypeId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
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
     * Gets the value of {@link #roomTypeId}.
     *
     * @return the value of {@link #roomTypeId}.
     */
    public int getRoomTypeId() {
        return roomTypeId;
    }

    /**
     * This is a setter which sets the roomTypeId
     *
     * @param roomTypeId - the roomTypeId to be set
     */
    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
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
}
