package com.example.flowerstore.ui.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.R;
import com.example.flowerstore.model.entity.Flower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerItemAdapter extends RecyclerView.Adapter<FlowerItemAdapter.FlowerViewHolder> {

    private final List<Flower> flowers;
    private Map<Integer, Integer> favorite_map = new HashMap();
    private FlowerViewHolder.ViewHolderListener viewHolderListener;
    private Integer valueOfPieces;

    public FlowerItemAdapter(List<Flower> flowers, FlowerViewHolder.ViewHolderListener viewHolderListener) {
        this.flowers = flowers;
        this.viewHolderListener = viewHolderListener;


    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.flower_item, parent, false);
        return new FlowerViewHolder(recyclerRow);
    }


    @Override
    public void onBindViewHolder(@NonNull final FlowerViewHolder holder, int position) {
        final Flower flower = flowers.get(position);
        final ImageView imageFavorite = holder.favorite;
        holder.flowerName.setText(flower.getName());
        holder.priceValue.setText(flower.getPrice().toString()+" $");

        switch (flower.getName()) {
            case "Daisy":
                holder.flowerImage.setImageResource(R.drawable.daisy);
                break;
            case "Rose":
                holder.flowerImage.setImageResource(R.drawable.rose_transparent);
                break;
            case "Tulip":
                holder.flowerImage.setImageResource(R.drawable.tulip);
                break;
            case "Lotus":
                holder.flowerImage.setImageResource(R.drawable.lotus);
                break;
            case "Begonia":
                holder.flowerImage.setImageResource(R.drawable.begonia);
                break;
            case "Anemone":
                holder.flowerImage.setImageResource(R.drawable.anemone);
                break;
            case "Marigold":
                holder.flowerImage.setImageResource(R.drawable.marigold);
                break;
            default:
                holder.flowerImage.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.favorite.setImageResource(R.drawable.unfavorite);
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolderListener.onFavoriteButtonClicked(flower);
                if (flower.isFavorite()) {
                    imageFavorite.setImageResource(R.drawable.favorite);
                } else {
                    imageFavorite.setImageResource(R.drawable.unfavorite);
                }
            }
        });

        List<String> flowerCartQuantities = new ArrayList<String>();
        for (Integer numberOfPieces : flower.getPieces()) {
            flowerCartQuantities.add(numberOfPieces.toString());
        }

        holder.piecesNumber.setAdapter(
                new ArrayAdapter<String>(
                        ((HomeFragment) viewHolderListener).getActivity(),
                        android.R.layout.simple_spinner_dropdown_item,
                        flowerCartQuantities)
        );

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pieces = Integer.parseInt((String) holder.piecesNumber.getSelectedItem());
                Log.d("this", "onItemSELECTED: " + valueOfPieces);
                viewHolderListener.onCartButtonClicked(flower, pieces);


            }
        });
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

        public interface ViewHolderListener {
            void onFavoriteButtonClicked(Flower flower);

            void onCartButtonClicked(Flower flower, Integer numberOfPieces);
        }


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
