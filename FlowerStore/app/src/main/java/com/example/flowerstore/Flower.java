package com.example.flowerstore;

import java.util.List;

public class Flower {

    private String name;
    private String price;
    private List<String> pieces;
    private int imageFlower;
    private boolean favorite;

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    private boolean inCart;

    public Flower(String name, String price, List<String> pieces, int imageFlower, boolean favorite, boolean inCart) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.imageFlower = imageFlower;
        this.favorite= favorite;
        this.inCart= inCart;
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

    public List<String> getPieces() {
        return pieces;
    }

    public void setPieces(List<String> pieces) {
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
