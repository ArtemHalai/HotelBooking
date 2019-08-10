package model.dto;

import model.entity.RoomRequest;

import java.util.ArrayList;
import java.util.List;

public class RoomRequestsAdminDto {
    private int page;
    private int count;
    private List<RoomRequest> list = new ArrayList<>();

    public RoomRequestsAdminDto() {
    }

    public RoomRequestsAdminDto(int page, int count, List<RoomRequest> list) {
        this.page = page;
        this.count = count;
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<RoomRequest> getList() {
        return list;
    }

    public void setList(List<RoomRequest> list) {
        this.list = list;
    }
}
