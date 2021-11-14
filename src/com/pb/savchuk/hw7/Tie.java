package com.pb.savchuk.hw7;

public class Tie extends Clothes implements ManClothes{
    private String name;

    public Tie (Size size, int price, String color, String name) {
        super(size, price, color);
        this.name = name;
    }

    @Override
    public void dressMan() {
        System.out.println("название: " + this.name + ", размер: " + getSize() +
                ", цена: " + getPrice() + ", цвет: " + getColor() + ".");
    }

}
