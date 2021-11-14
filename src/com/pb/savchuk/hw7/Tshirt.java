package com.pb.savchuk.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
    private String name;

    public Tshirt(Size size, int price, String color, String name) {
        super(size, price, color);
        this.name = name;
    }

    @Override
    public void dressMan() {
        System.out.println("название: " + this.name + ", размер: " + getSize() +
                ", цена: " + getPrice() + ", цвет: " + getColor() + ".");
    }

    @Override
    public void dressWomen() {
        System.out.println("название: " + this.name + ", размер: " + getSize() +
                ", цена: " + getPrice() + ", цвет: " + getColor() + ".");
    }
}
