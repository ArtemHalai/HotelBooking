package model.entity;

/**
 * Represents a room.
 */
public class Room {
    private int id;
    private int roomNumber;
    private boolean balcony;
    private boolean smoke;
    /**
     * Represents the room type.
     */
    private RoomType roomType;
    private double price;

    /**
     * Creates a room without params.
     */
    public Room() {
    }

    /**
     * Creates a room with the specified id, price.
     *
     * @param id    The room’s id.
     * @param price The room’s price.
     */
    public Room(int id, double price) {
        this.id = id;
        this.price = price;
    }

    /**
     * Creates a room with the specified roomNumber, balcony, smoke, roomTypeId, price.
     *
     * @param roomNumber The room’s number.
     * @param balcony    The room’s balcony.
     * @param smoke      The room’s smoke.
     * @param roomType The room’s type.
     * @param price      The room’s price.
     */
    public Room(int roomNumber, boolean balcony, boolean smoke, RoomType roomType, double price) {
        this.roomNumber = roomNumber;
        this.balcony = balcony;
        this.smoke = smoke;
        this.roomType = roomType;
        this.price = price;
    }

    /**
     * Creates a room with the specified id, roomNumber, balcony, smoke, roomTypeId, price.
     *
     * @param id         The room's id.
     * @param roomNumber The room’s number.
     * @param balcony    The room’s balcony.
     * @param smoke      The room’s smoke.
     * @param roomType The room’s type.
     * @param price      The room’s price.
     */
    public Room(int id, int roomNumber, boolean balcony, boolean smoke, RoomType roomType, double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.balcony = balcony;
        this.smoke = smoke;
        this.roomType = roomType;
        this.price = price;
    }

    /**
     * Gets the value of {@link #roomNumber}.
     *
     * @return the value of {@link #roomNumber}.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * This is a setter which sets the roomNumber
     *
     * @param roomNumber - the roomNumber to be set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
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
     * Gets the value of {@link #balcony}.
     *
     * @return the value of {@link #balcony}.
     */
    public boolean isBalcony() {
        return balcony;
    }

    /**
     * This is a setter which sets the balcony
     *
     * @param balcony - the balcony to be set
     */
    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    /**
     * Gets the value of {@link #smoke}.
     *
     * @return the value of {@link #smoke}.
     */
    public boolean isSmoke() {
        return smoke;
    }

    /**
     * This is a setter which sets the smoke
     *
     * @param smoke - the smoke to be set
     */
    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    /**
     * Gets the value of {@link #roomType}.
     *
     * @return the value of {@link #roomType}.
     */
    public RoomType getRoomTypeId() {
        return roomType;
    }

    /**
     * This is a setter which sets the roomTypeId
     *
     * @param roomType - the roomType to be set
     */
    public void setRoomTypeId(RoomType roomType) {
        this.roomType = roomType;
    }
}
