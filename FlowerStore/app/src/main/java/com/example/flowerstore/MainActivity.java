package com.example.flowerstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        // Initialize recycler view adapter with car list (data source)
        FlowerItemAdapter recyclerViewAdapter = new FlowerItemAdapter(flowerList);

        // Set recycler view adapter to recycler view
        recyclerView.setAdapter(recyclerViewAdapter);





    }
}
