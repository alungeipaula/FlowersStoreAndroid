package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements FlowerItemAdapter.FlowerViewHolder.ViewHolderListener {
    //favorite flowerList
    private List<Flower> favoriteFlowerList = new ArrayList<>();



    //flower list in cart
    private Map<Flower, String> inCartFlowerMap = new HashMap<Flower, String>();

    private final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the data source
        DataSource dataSource = new DataSource();
        List<Flower> flowerList = dataSource.getFlowers();



        // Initialize recycler view
        RecyclerView recyclerView = findViewById(R.id.offer_list);

        //Initialize the linear layout manager -> handles organization of UI components in a View
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        // Set linear layout manager to recycler view
        recyclerView.setLayoutManager(layoutManager);

        // Initialize recycler view adapter with flower list (data source)

        FlowerItemAdapter recyclerViewAdapter = new FlowerItemAdapter(flowerList,this );

        // Set recycler view adapter to recycler view
        recyclerView.setAdapter(recyclerViewAdapter);

    }


    @Override
    public void onFavoriteButtonClicked(Flower flower) {
        if(!flower.isFavorite()){

            flower.setFavorite(true);
            favoriteFlowerList.add(flower);

        }else{
            flower.setFavorite(false);
            favoriteFlowerList.remove(flower);

        }
        for(Flower flw: favoriteFlowerList){
            Log.d("My tag: ",flw.getName());
        }
    }

    @Override
    public void onCartButtonClicked(Flower flower, String numberOfPieces) {
        Log.d("this", "number of pieces: "+ numberOfPieces);
        Log.d("this", "flower: "+ flower.getName());

        inCartFlowerMap.put(flower, numberOfPieces);

        for (Map.Entry<Flower,String> entry : inCartFlowerMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    @Override
    public ArrayAdapter<String> getSpinnerAdapter(List<String> numberOfPieces) {
        return new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                numberOfPieces);
    }

    public Map<Flower, String> getInCartFlowerMap() {
        return inCartFlowerMap;
    }



}
