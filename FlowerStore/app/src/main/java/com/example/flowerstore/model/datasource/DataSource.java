package com.example.flowerstore.model.datasource;

import android.util.Log;

import com.example.flowerstore.R;
import com.example.flowerstore.model.entity.Flower;
import com.example.flowerstore.ui.WelcomeActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSource {

    private List<Flower> allFlowers = new ArrayList<Flower>();
    private Map<Flower, Integer> cartContent;
    private WelcomeActivity welcomeActivity = new WelcomeActivity();

    public WelcomeActivity getWelcomeActivity() {
        return welcomeActivity;
    }

    public List<Flower> getFavourites() {
        return favourites;
    }

    private List<Flower> favourites;

    public DataSource() {
        cartContent = new HashMap<Flower, Integer>();
        favourites = new ArrayList<Flower>();
    }

    public void setFlowers(List<Flower> flowers) {
        List<Flower> flowerList = new ArrayList<>();

        List<Integer> piecesNumber = new ArrayList<>(1);
        piecesNumber.add(1);
        piecesNumber.add(2);
        piecesNumber.add(3);
        piecesNumber.add(4);
        piecesNumber.add(5);
        piecesNumber.add(6);
        piecesNumber.add(7);

        for (Flower fl : flowers) {
            flowerList.add(new Flower(fl.getName(), fl.getPrice(), piecesNumber, R.drawable.tulip, fl.isFavorite(), fl.isInCart(), fl.getDescription()));
        }
        for (Flower f : flowerList) {
            Log.d("my tag", f.toString());
        }

        allFlowers = flowerList;
    }

    public List<Flower> getFlowers() {
        return allFlowers;
    }

    public void addToCart(Flower flower, Integer numberOfPieces) {
        cartContent.put(flower, numberOfPieces);

        for (Map.Entry<Flower, Integer> entry : cartContent.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    public Map<Flower, Integer> getCartContent() {
        return cartContent;
    }

    public Double getCartTotal() {
        Double total = 0.0;
        for (Map.Entry<Flower, Integer> entry : cartContent.entrySet()) {
            Double price = entry.getKey().getPrice();
            Integer quantity = entry.getValue();
            total += price * quantity;
        }
        return total;
    }

    public void changeFavoriteStatus(Flower flower) {
        if (!flower.isFavorite()) {
            flower.setFavorite(true);
            favourites.add(flower);

        } else {
            flower.setFavorite(false);
            favourites.remove(flower);

        }
    }

    public void removeCartEntry(Flower flower) {
        cartContent.remove(flower);
    }

    public void removeFavoriteEntry(Flower flower) {
        favourites.remove(flower);
    }

    public void clearCart() {
        cartContent.clear();
    }
}
