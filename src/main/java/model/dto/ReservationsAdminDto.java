package model.dto;

import model.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationsAdminDto {
    private int page;
    private int count;
    private List<Reservation> list = new ArrayList<>();

    public ReservationsAdminDto() {
    }

    public ReservationsAdminDto(int page, int count, List<Reservation> list) {
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

    public List<Reservation> getList() {
        return list;
    }

    public void setList(List<Reservation> list) {
        this.list = list;
    }
}
