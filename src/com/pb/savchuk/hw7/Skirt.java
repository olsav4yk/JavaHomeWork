package com.pb.savchuk.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private String name;

    public Skirt (Size size, int price, String color, String name) {
        super(size, price, color);
        this.name = name;
    }

    @Override
    public void dressWomen() {
        System.out.println("название: " + this.name + ", размер: " + getSize() +
                ", цена: " + getPrice() + ", цвет: " + getColor() + ".");
    }
}
