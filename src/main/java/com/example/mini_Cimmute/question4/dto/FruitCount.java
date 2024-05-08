package com.example.mini_Cimmute.question4.dto;

public class FruitCount {
    private long count;
    private String name;
    public long getCount() {
        return count;
    }


    protected FruitCount() {
    }

    public FruitCount(long count) {
        this.count=count;
    }
}
