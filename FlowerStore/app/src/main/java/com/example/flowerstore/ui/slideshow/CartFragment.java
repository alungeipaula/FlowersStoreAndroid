package com.example.flowerstore.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.R;
import com.example.flowerstore.model.entity.Flower;
import com.example.flowerstore.ui.FlowerStoreApp;
import com.example.flowerstore.ui.NavigationActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartFragment extends Fragment implements CartItemAdapter.CartItemRecyclerViewHolder.ViewHolderListener {

    private TextView total_products_tv;
    private TextView total_products_value_tv;
    private RecyclerView cartRecyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_cart, container, false);


        //return root;
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize recycler view
        cartRecyclerView = view.findViewById(R.id.cart_recyclerView);

        //Initialize the linear layout manager -> handles organization of UI components in a View
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);

        cartRecyclerView.setLayoutManager(layoutManager);

        CartItemAdapter recyclerViewAdapter = new CartItemAdapter(
                ((FlowerStoreApp)getActivity().getApplication()).getDataSource().getCartContent(),
                this
        );

        // Set recycler view adapter to recycler view
        cartRecyclerView.setAdapter(recyclerViewAdapter);

        // Initialize recycler view adapter with flower list (data source)

        total_products_value_tv = view.findViewById(R.id.total_products_value_tv);
        Double cartTotal = ((FlowerStoreApp)getActivity().getApplication()).getDataSource().getCartTotal();
        total_products_value_tv.setText(cartTotal.toString());

        total_products_tv = view.findViewById(R.id.total_products_tv);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(CartFragmentDirections.actionNavCartToNavOrder());
            }
        });

    }

    @Override
    public void onDeleteCartItemButtonClicked(Flower flower) {
        ((FlowerStoreApp)getActivity().getApplication()).getDataSource().removeCartEntry(flower);

        //refresh total
        Double cartTotal = ((FlowerStoreApp)getActivity().getApplication()).getDataSource().getCartTotal();
        total_products_value_tv.setText(cartTotal.toString());
        //refresh items
        CartItemAdapter recyclerViewAdapter = new CartItemAdapter(
                ((FlowerStoreApp)getActivity().getApplication()).getDataSource().getCartContent(),
                this
        );
       cartRecyclerView.setAdapter(recyclerViewAdapter);
    }
}