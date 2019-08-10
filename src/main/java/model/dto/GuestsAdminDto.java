package model.dto;

import model.entity.Guest;

import java.util.ArrayList;
import java.util.List;

public class GuestsAdminDto {
    private int page;
    private int count;
    private List<Guest> list = new ArrayList<>();

    public GuestsAdminDto() {
    }

    public GuestsAdminDto(int page, int count, List<Guest> list) {
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

    public List<Guest> getList() {
        return list;
    }

    public void setList(List<Guest> list) {
        this.list = list;
    }
}
