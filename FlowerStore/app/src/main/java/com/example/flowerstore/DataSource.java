package com.example.flowerstore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public List<Flower> getFlowers(){
        List<Flower> flowerList = new ArrayList<>();
        List<Integer> piecesNumber = new ArrayList<>(1);
        piecesNumber.add(1);
        piecesNumber.add(2);
        piecesNumber.add(3);
        piecesNumber.add(4);
        piecesNumber.add(5);
        piecesNumber.add(6);
        piecesNumber.add(7);
        flowerList.add(new Flower("Tulip", "4.0$", piecesNumber, R.drawable.tulip));
        flowerList.add(new Flower("Rose", "5.0$", piecesNumber, R.drawable.rose));
        flowerList.add(new Flower("Lotus", "10.0$", piecesNumber, R.drawable.lotus));
        flowerList.add(new Flower("Daisy", "3.0$", piecesNumber, R.drawable.daisy));
        return flowerList;
    }

}
