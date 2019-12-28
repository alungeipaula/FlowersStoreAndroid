package com.example.flowerstore;

import android.content.res.TypedArray;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerItemAdapter extends RecyclerView.Adapter<FlowerItemAdapter.FlowerViewHolder> {

    private final List<Flower> flowers;
    private Map<Integer, Integer> favorite_map = new HashMap();

    public FlowerItemAdapter(List<Flower> flowers){
        this.flowers= flowers;
    }
    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.flower_item, parent, false);
        return new FlowerViewHolder(recyclerRow);
    }



    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        final Flower flower = flowers.get(position);
        holder.flowerName.setText(flower.getName());
        holder.priceValue.setText(flower.getPrice());

        switch (flower.getName()){
            case "Daisy": holder.flowerImage.setImageResource(R.drawable.daisy); break;
            case "Rose": holder.flowerImage.setImageResource(R.drawable.rose); break;
            case "Tulip": holder.flowerImage.setImageResource(R.drawable.tulip); break;
            case "Lotus": holder.flowerImage.setImageResource(R.drawable.lotus); break;
            default : holder.flowerImage.setImageResource(R.drawable.ic_launcher_background);
        }


        if (flower.isFavorite()){
            holder.favorite.setImageResource(R.drawable.favorite);
        }else{
            holder.favorite.setImageResource((R.drawable.unfavorite));
        }




       /* holder.piecesNumber.setAdapter(return new ArrayAdapter<Integer>(MainActivity.class,
                android.R.layout.simple_spinner_dropdown_item,
                flower.getPieces()));*/

    }



    @Override
    public int getItemCount() {
        return flowers.size();
    }

    static class FlowerViewHolder extends RecyclerView.ViewHolder {
        final TextView flowerName;
        final ImageView flowerImage;
        final TextView price;
        final TextView priceValue;
        final TextView pieces;
        final Spinner piecesNumber;
        final ImageView favorite;
        final ImageView addToCart;


        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);

            flowerName = itemView.findViewById(R.id.flower_name);
            flowerImage = itemView.findViewById(R.id.flower_image);
            price = itemView.findViewById(R.id.price);
            priceValue = itemView.findViewById(R.id.price_value);
            pieces = itemView.findViewById(R.id.pieces);
            piecesNumber = itemView.findViewById(R.id.pieces_number);
            favorite = itemView.findViewById(R.id.favorite_image);
            addToCart = itemView.findViewById(R.id.add_to_cart);
        }



    }
}
