package com.example.myecommerceapp;

import java.util.ArrayList;

public class Util {

    private static ArrayList<Product> allProducts;
    private static int id = 0;

    public Util() {
        allProducts = new ArrayList<>();
        initAllProducts();
    }

    public static ArrayList<Product> getAllProducts() {
        return allProducts;
    }


    private static void initAllProducts() {
        String name = "";
        String seller = "";
        double price = 0;
        String imageUrl = "";
        String description = "";

        id++;
        name = "Blackmores Evening Primrose Oil + Fish Oil 30caps";
        seller = "blackmores.sg";
        price = 7.90;
        imageUrl = "https://shopee.sg/Blackmores-Evening-Primrose-Oil-Fish-Oil-30caps-i.18092986.1077260752";
        description = "Ships From Singpost Regional eCommerce Logistics Hub, 37 Greenwich Drive...";
        allProducts.add(new Product(id, name, seller, price, imageUrl, description));
    }
}
