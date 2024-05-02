package com.example.mini_Cimmute.question4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit {
    @Id//javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    private final String name;

    private final long price;

    public String getName() {
        return name;
    }


    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }


    public Fruit(long id, String name, long price) {
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된이름입니다"));
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }
}


