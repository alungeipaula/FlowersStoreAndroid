package com.example.flowerstore.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.R;
import com.example.flowerstore.model.datasource.DataSource;
import com.example.flowerstore.model.entity.Flower;
import com.example.flowerstore.ui.FlowerStoreApp;
import com.example.flowerstore.ui.NavigationActivity;

import java.util.List;

public class HomeFragment extends Fragment implements FlowerItemAdapter.FlowerViewHolder.ViewHolderListener {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(root);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View layout) {

        List<Flower> flowerList = ((FlowerStoreApp)getActivity().getApplication()).getDataSource().getFlowers();

        // Initialize recycler view
        RecyclerView recyclerView = layout.findViewById(R.id.offer_list);

        //Initialize the linear layout manager -> handles organization of UI components in a View
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);

        // Set linear layout manager to recycler view
        recyclerView.setLayoutManager(layoutManager);

        // Initialize recycler view adapter with flower list (data source)

        FlowerItemAdapter recyclerViewAdapter = new FlowerItemAdapter(flowerList, this);

        // Set recycler view adapter to recycler view
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onFavoriteButtonClicked(Flower flower) {
        ((FlowerStoreApp)getActivity().getApplication()).getDataSource().changeFavoriteStatus(flower);
        Toast.makeText(getActivity(), "The flower is added to Favorites", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCartButtonClicked(Flower flower, Integer numberOfPieces) {
        Log.d("this", "number of pieces: " + numberOfPieces);
        Log.d("this", "flower: " + flower.getName());

        ((FlowerStoreApp)getActivity().getApplication()).getDataSource().addToCart(flower, numberOfPieces);
        Toast.makeText(getActivity(), "The flower is added to Cart", Toast.LENGTH_SHORT).show();

    }
}