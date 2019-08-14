package model.dto;

/**
 * Represents a room request dto.
 */
public class RoomRequestDto {
    private String roomType;
    private String dateIn;
    private String dateOut;

    /**
     * Creates a room request dto without params.
     */
    public RoomRequestDto() {
    }

    /**
     * Creates a room request dto with the specified roomType, dateIn, dateOut.
     *
     * @param roomType  The room request dto's roomType.
     * @param dateIn  The room request dto's dateIn.
     * @param dateOut  The room request dto's dateOut.
     */
    public RoomRequestDto(String roomType, String dateIn, String dateOut) {
        this.roomType = roomType;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    /**
     * Gets the value of {@link #roomType}.
     *
     * @return the value of {@link #roomType}.
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * This is a setter which sets the roomType
     *
     * @param roomType - the roomType to be set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Gets the value of {@link #dateIn}.
     *
     * @return the value of {@link #dateIn}.
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * This is a setter which sets the dateIn
     *
     * @param dateIn - the dateIn to be set
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * Gets the value of {@link #dateOut}.
     *
     * @return the value of {@link #dateOut}.
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * This is a setter which sets the dateOut
     *
     * @param dateOut - the dateOut to be set
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
}
