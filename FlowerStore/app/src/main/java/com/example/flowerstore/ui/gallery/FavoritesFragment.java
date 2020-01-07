package com.example.flowerstore.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.R;
import com.example.flowerstore.model.datasource.DataSource;
import com.example.flowerstore.model.entity.Flower;
import com.example.flowerstore.ui.FlowerStoreApp;
import com.example.flowerstore.ui.NavigationActivity;
import com.example.flowerstore.ui.slideshow.CartItemAdapter;

import java.util.List;

public class FavoritesFragment extends Fragment implements FavoriteItemAdapter.FavoriteViewHolder.ViewHolderListener{


    private TextView favoriteTag;
    private RecyclerView favoritesRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_favorites, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View layout) {

        favoriteTag = layout.findViewById(R.id.favorite_tag);

        favoritesRecyclerView = layout.findViewById(R.id.favorites_recyclerView);

        //Initialize the linear layout manager -> handles organization of UI components in a View
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);

        favoritesRecyclerView.setLayoutManager(layoutManager);
        // Initialize recycler view adapter with flower list (data source)

        FavoriteItemAdapter recyclerViewAdapter = new FavoriteItemAdapter(((FlowerStoreApp)getActivity().getApplication()).getDataSource().getFavourites(), this);

        // Set recycler view adapter to recycler view
        favoritesRecyclerView.setAdapter(recyclerViewAdapter);
    }
// nu stiu de ce pierzi vremea acuma cu atat refactorizare.. sry
    @Override
    public void onDeleteFavoriteItemButtonClicked(Flower flower) {
        ((FlowerStoreApp)getActivity().getApplication()).getDataSource().removeFavoriteEntry(flower);

        //refresh items
        FavoriteItemAdapter recyclerViewAdapter = new FavoriteItemAdapter(
                ((FlowerStoreApp)getActivity().getApplication()).getDataSource().getFavourites(),
                this
        );
        favoritesRecyclerView.setAdapter(recyclerViewAdapter);
    }
}