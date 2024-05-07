package com.example.mini_Cimmute.question4.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fruit {
    @Id//javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column
    private  String name;

    private  long price;
//    @Column(name="warehousingDate")
    private  LocalDate warehousing_date;
    private  boolean is_sale;
    ///////////////////////////////////////////
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousing_date() {
        return warehousing_date;
    }

    public boolean isIs_sale() {
        return is_sale;
    }

    ///////////////////////////////////////////
    public Fruit(long id, String name, LocalDate warehousingDate, long price, boolean is_sale ) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된이름입니다"));
        }
        this.id = id;
        this.name = name;
        this.warehousing_date =warehousingDate;
        this.price=price;
        this.is_sale=is_sale;
    }
    protected Fruit(){

    }
    public void FruitUpdate_Is_Sale(boolean is_sale){
        this.is_sale=is_sale;
    }
    public void do_is_sale(boolean is_sale){
        this.is_sale= !this.is_sale;
    }
}


