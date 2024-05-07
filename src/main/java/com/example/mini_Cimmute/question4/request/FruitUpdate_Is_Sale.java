package com.example.mini_Cimmute.question4.request;

public class FruitUpdate_Is_Sale {
    private long id;
    public boolean is_sale;
    public long getId() {
        return id;
    }



    protected FruitUpdate_Is_Sale(){

    }
    public FruitUpdate_Is_Sale(long id) {
        this.id = id;
    }

    public boolean isIs_sale() {
        return is_sale;
    }
}
