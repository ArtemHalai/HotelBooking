package model.entity;

public class Room {
    private int id;
    private int roomNumber;
    private boolean balcony;
    private boolean smoke;
    private int roomTypeId;
    private double price;

    public Room() {
    }

    public Room(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public Room(int roomNumber, boolean balcony, boolean smoke, int roomTypeId, double price) {
        this.roomNumber = roomNumber;
        this.balcony = balcony;
        this.smoke = smoke;
        this.roomTypeId = roomTypeId;
        this.price = price;
    }

    public Room(int id, int roomNumber, boolean balcony, boolean smoke, int roomTypeId, double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.balcony = balcony;
        this.smoke = smoke;
        this.roomTypeId = roomTypeId;
        this.price = price;
    }



    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
