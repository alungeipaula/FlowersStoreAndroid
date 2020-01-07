package com.example.flowerstore.ui.slideshow;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.R;
import com.example.flowerstore.model.entity.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemRecyclerViewHolder> {

    private List<Pair<Flower, Integer>> cartList = new ArrayList<Pair<Flower, Integer>>();
    private CartItemRecyclerViewHolder.ViewHolderListener listener;

    public CartItemAdapter(Map<Flower, Integer> inCartFlowerMap, CartItemRecyclerViewHolder.ViewHolderListener listener) {
        for (Map.Entry<Flower, Integer> entry : inCartFlowerMap.entrySet()) {
            cartList.add(new Pair<Flower, Integer>(entry.getKey(), (entry.getValue())));
        }
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartItemRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.cart_item, parent, false);
        return new CartItemAdapter.CartItemRecyclerViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartItemRecyclerViewHolder holder, int position) {

        final Flower flower = (Flower) cartList.get(position).first;
        final Integer piecesNumber = cartList.get(position).second;

        holder.flowerNameTv.setText(flower.getName());
        holder.noPiecesCartUtemTv.setText("x" + piecesNumber);
        holder.priceProductCartItemTv.setText(flower.getPrice().toString()+"$");

        Double totalSumItem = piecesNumber * flower.getPrice();
        holder.totalProductCartItemTv.setText(totalSumItem + "$");

        holder.deleteCartItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flowerPosition = holder.getAdapterPosition();
                listener.onDeleteCartItemButtonClicked(cartList.get(flowerPosition).first);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    static class CartItemRecyclerViewHolder extends RecyclerView.ViewHolder {

        public interface ViewHolderListener {
            void onDeleteCartItemButtonClicked(Flower flower);
        }

        final TextView flowerNameTv;
        final ImageButton deleteItemIb;
        final ImageView productImageCartItemIv;
        final TextView noPiecesCartUtemTv;
        final TextView priceProductCartItemTv;
        final TextView totalProductCartItemTv;
        final ImageButton deleteCartItemButton;

        CartItemRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            flowerNameTv = itemView.findViewById(R.id.flower_name_cart_item_tv);
            deleteItemIb = itemView.findViewById(R.id.delete_item_ib);
            productImageCartItemIv = itemView.findViewById(R.id.product_image_cart_item_iv);
            noPiecesCartUtemTv = itemView.findViewById(R.id.no_pieces_cart_item_tv);
            priceProductCartItemTv = itemView.findViewById(R.id.price_product_cart_item_tv);
            totalProductCartItemTv = itemView.findViewById(R.id.total_product_cart_item_tv);
            deleteCartItemButton = itemView.findViewById(R.id.delete_item_ib);
        }
    }


}
