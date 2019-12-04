package com.example.flowerstore;

import java.util.List;

public class Flower {

    private String name;
    private String price;
    private List<Integer> pieces;
    private int imageFlower;

    public Flower(String name, String price, List<Integer> pieces, int imageFlower) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.imageFlower = imageFlower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Integer> getPieces() {
        return pieces;
    }

    public void setPieces(List<Integer> pieces) {
        this.pieces = pieces;
    }

    public int getImageFlower() {
        return imageFlower;
    }

    public void setImageFlower(int imageFlower) {
        this.imageFlower = imageFlower;
    }

    @Override
    public String toString(){
        return getPieces().toString();
    }
}
