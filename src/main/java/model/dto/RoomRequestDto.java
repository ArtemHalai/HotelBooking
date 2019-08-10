package model.dto;

public class RoomRequestDto {
    private String roomType;
    private String dateIn;
    private String dateOut;

    public RoomRequestDto() {
    }

    public RoomRequestDto(String roomType, String dateIn, String dateOut) {
        this.roomType = roomType;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
}
