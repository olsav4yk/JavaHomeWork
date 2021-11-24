package com.spdu2021;



public class Product {
    String productName;
    String type;
    int cost;

    public Product(String productName, String type, int cost) {
        this.productName = productName;
        this.type = type;
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }
}





