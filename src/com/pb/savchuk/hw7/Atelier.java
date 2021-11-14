package com.pb.savchuk.hw7;

public class Atelier {
    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt(Size.XXS, 100, "синяя", "футболка");
        Pants pants = new Pants(Size.XS, 120, "черные", "штаны");
        Skirt skirt = new Skirt(Size.S, 140, "красная", "юбка");
        Tie tie = new Tie(Size.M, 50, "зелёный", "галстук");

        Clothes[] clothes = new Clothes[]{tshirt, pants, skirt, tie};
        dressMan(clothes);
        dressWomen(clothes);
    }

    public static void dressWomen(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes c : clothes) {
            if (c instanceof WomenClothes) {
                ((WomenClothes) c).dressWomen();
            }
        }
    }
    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes c : clothes) {
            if (c instanceof ManClothes) {
                ((ManClothes) c).dressMan();
            }
        }
    }
}