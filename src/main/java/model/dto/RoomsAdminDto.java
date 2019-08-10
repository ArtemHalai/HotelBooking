package model.dto;

import model.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomsAdminDto {
    private int page;
    private int count;
    private List<Room> list = new ArrayList<>();

    public RoomsAdminDto() {
    }

    public RoomsAdminDto(int page, int count, List<Room> list) {
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

    public List<Room> getList() {
        return list;
    }

    public void setList(List<Room> list) {
        this.list = list;
    }
}
