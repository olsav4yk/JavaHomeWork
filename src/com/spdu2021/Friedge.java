package com.spdu2021;

public class Friedge {
    int[] n;
    Product[] prod;
    int ol = 1;
    int amount=0;

    public Friedge(int[] n, Product[] prod) {
        this.n = n;
        this.prod = prod;
        this.ol = ol;
    }

    public void list(Receipt... receipts) {

            for (Receipt rec : receipts) {
                for (int i = 0; i < prod.length; i++) {
                    if (rec.ingredient[i] > n[i]) {
                        System.out.println(ol + ". " + prod[i].productName + " (" + (rec.ingredient[i] - n[i]) +
                                " шт.) : " + prod[i].cost + " грн.");
                        ol++;
                        amount +=prod[i].cost;
                    }

                }
                System.out.println("Сума : " + amount + "грн.");
            }
    }
}