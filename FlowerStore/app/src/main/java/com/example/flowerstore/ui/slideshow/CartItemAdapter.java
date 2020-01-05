package com.example.flowerstore.ui.slideshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.Flower;
import com.example.flowerstore.FlowerItemAdapter;
import com.example.flowerstore.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.RecyclerViewHolder> {

    private final Map<Flower, String> inCartFlowerMap ;

    public CartItemAdapter(Map<Flower, String> inCartFlowerMap) {
        this.inCartFlowerMap = inCartFlowerMap;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.cart_item, parent, false);
        return new CartItemAdapter.RecyclerViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        List flowersFromCartList = new ArrayList<Flower>();
        List piecesOfFlowersList = new ArrayList<String>();
        for (Map.Entry<Flower,String> entry : inCartFlowerMap.entrySet()){
            flowersFromCartList.add(entry.getKey());
            piecesOfFlowersList.add(entry.getValue());
        }
        final Flower flower = (Flower)flowersFromCartList.get(position);
        final String piecesNumber = (String)flowersFromCartList.get(position);
        holder.flowerNameTv.setText( flower.getName());
        holder.noPiecesCartUtemTv.setText("x"+piecesNumber);
        holder.priceProductCartItemTv.setText(flower.getPrice());

        int totalSumItem = Integer.parseInt(piecesNumber)  * Integer.parseInt(flower.getPrice());

        holder.totalProductCartItemTv.setText(totalSumItem + "$");



    }

    @Override
    public int getItemCount() {
        return inCartFlowerMap.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        final TextView flowerNameTv;
        final ImageButton deleteItemIb;
        final ImageView productImageCartItemIv;
        final TextView noPiecesCartUtemTv;
        final TextView priceProductCartItemTv;
        final TextView totalProductCartItemTv;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            flowerNameTv = itemView.findViewById(R.id.flower_name_cart_item_tv);
            deleteItemIb = itemView.findViewById(R.id.delete_item_ib);
            productImageCartItemIv = itemView.findViewById(R.id.product_image_cart_item_iv);
            noPiecesCartUtemTv = itemView.findViewById(R.id.no_pieces_cart_item_tv);
            priceProductCartItemTv = itemView.findViewById(R.id.price_product_cart_item_tv);
            totalProductCartItemTv = itemView.findViewById(R.id.total_product_cart_item_tv);



        }
    }



}
