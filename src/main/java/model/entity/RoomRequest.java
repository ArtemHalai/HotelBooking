package model.entity;

import java.sql.Date;

public class RoomRequest {
    private int id;
    private int roomTypeId;
    private Date dateIn;
    private Date dateOut;

    public RoomRequest(int roomTypeId, Date dateIn, Date dateOut) {
        this.roomTypeId = roomTypeId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public RoomRequest(int id, int roomTypeId, Date dateIn, Date dateOut) {
        this.id = id;
        this.roomTypeId = roomTypeId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
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
}
