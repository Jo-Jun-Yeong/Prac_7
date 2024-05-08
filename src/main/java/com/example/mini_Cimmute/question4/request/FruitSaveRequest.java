package com.example.mini_Cimmute.question4.request;

import com.example.mini_Cimmute.question4.domain.Fruit;

import java.time.LocalDate;

public class FruitSaveRequest {
    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;

    private boolean is_sale;
    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public boolean isIs_sale() {
        return is_sale;
    }

    public FruitSaveRequest(Fruit fruit) {
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousing_date();
    }
    protected FruitSaveRequest(){

    }
}
