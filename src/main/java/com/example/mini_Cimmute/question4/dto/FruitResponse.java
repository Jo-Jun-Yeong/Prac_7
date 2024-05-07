package com.example.mini_Cimmute.question4.dto;


import com.example.mini_Cimmute.question4.domain.Fruit;

import java.time.LocalDate;

public class FruitResponse {
    private final long id;
    private final String name;
    private final LocalDate warehousingDate;
    private final long price;
    private boolean is_sale;
    ///////////////////////////////////////////
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
    public long getPrice() {
        return price;
    }

    public boolean isIs_sale() {
        return is_sale;
    }
    ///////////////////////////////////////////////


    public FruitResponse(Fruit fruit) {
        this.id=fruit.getId();
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousing_date();
        this.is_sale=is_sale;
    }

    public FruitResponse(long id, String name, LocalDate warehousingDate, long price,boolean is_sale) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.is_sale=is_sale;
    }
}
