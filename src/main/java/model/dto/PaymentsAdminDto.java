package model.dto;

import model.entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentsAdminDto {
    private int page;
    private int count;
    private List<Payment> list = new ArrayList<>();

    public PaymentsAdminDto() {
    }

    public PaymentsAdminDto(int page, int count, List<Payment> list) {
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

    public List<Payment> getList() {
        return list;
    }

    public void setList(List<Payment> list) {
        this.list = list;
    }
}
