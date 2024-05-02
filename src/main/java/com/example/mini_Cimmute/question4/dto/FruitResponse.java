package com.example.mini_Cimmute.question4.dto;


import java.time.LocalDate;

public class FruitResponse {



    private long id;

    private  String name;
    private  LocalDate warehousingDate;

    private  long price;
    private  boolean is_sale;

    public boolean isIs_sale() {
        return is_sale;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public FruitResponse(Fruit fruit, LocalDate warehousingDate, Boolean is_sale) {
        this.id=fruit.getId();
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = warehousingDate;
        this.is_sale=is_sale;
    }
}
