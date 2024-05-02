package com.example.mini_Cimmute.question4.dto;

public class FruitAmount {
    private long salesAmount;
    private long notSalesAMount;

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAMount() {
        return notSalesAMount;
    }

    public FruitAmount(long salesAmount, long notSalesAMount) {
        this.salesAmount = salesAmount;
        this.notSalesAMount = notSalesAMount;
    }
}
