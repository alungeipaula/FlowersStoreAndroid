package com.example.flowerstore.model.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Flower {

    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private Double price;

    private List<Integer> pieces;
    private int imageFlower;

    @SerializedName("favorite")
    private boolean favorite;
    @SerializedName("description")
    private String description;
    @SerializedName("inCart")
    private boolean inCart;


    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }




    public Flower(String name, Double price, List<Integer> pieces, int imageFlower, boolean favorite, boolean inCart, String description) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.imageFlower = imageFlower;
        this.favorite= favorite;
        this.inCart= inCart;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Flower{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", favorite='" + favorite + '\'' +
                ", inCart='" + inCart + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
