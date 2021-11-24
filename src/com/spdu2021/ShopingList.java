package com.spdu2021;

public class ShopingList {

    public static void main(String[] args) {

        Product egg = new Product("Яйця", "продукт тваринного походження", 20);
        Product potato = new Product("Картопля", "овочі", 10);
        Product apple = new Product("Яблуко", "фрукти", 8);

        Receipt receipt1 = new Receipt(new int[]{1, 3, 4}, new Product[]{egg, potato, apple});

        Friedge friedge = new Friedge(new int[]{2, 2, 3}, new Product[]{egg, potato, apple});

        friedge.list(receipt1);

    }

}
