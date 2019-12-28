package com.example.flowerstore;

import java.util.List;

public class Flower {

    private String name;
    private String price;
    private List<Integer> pieces;
    private int imageFlower;
    private boolean favorite;

    public Flower(String name, String price, List<Integer> pieces, int imageFlower, boolean favorite) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.imageFlower = imageFlower;
        this.favorite= favorite;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString(){
        return getPieces().toString();
    }
}
