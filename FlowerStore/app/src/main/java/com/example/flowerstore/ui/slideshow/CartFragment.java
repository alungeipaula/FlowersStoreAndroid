package com.example.flowerstore.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.DataSource;
import com.example.flowerstore.Flower;
import com.example.flowerstore.FlowerItemAdapter;
import com.example.flowerstore.MainActivity;
import com.example.flowerstore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartFragment extends Fragment {

    private TextView total_products_tv;
    private TextView total_products_value_tv;

    public CartFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


       View root = inflater.inflate(R.layout.fragment_cart, container, false);

        // Initialize recycler view
        RecyclerView recyclerView = (RecyclerView)root.findViewById(R.id.cart_recyclerView);

        //Initialize the linear layout manager -> handles organization of UI components in a View
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize recycler view adapter with flower list (data source)

        CartItemAdapter recyclerViewAdapter = new CartItemAdapter(new MainActivity().getInCartFlowerMap());


        // Set recycler view adapter to recycler view
        recyclerView.setAdapter(recyclerViewAdapter);

        //return root;

        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        total_products_tv = view.findViewById(R.id.total_products_tv);
        total_products_value_tv = view.findViewById(R.id.total_products_value_tv);

    }

}