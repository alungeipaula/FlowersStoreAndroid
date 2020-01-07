package com.example.flowerstore.ui.gallery;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowerstore.R;
import com.example.flowerstore.model.entity.Flower;
import com.example.flowerstore.ui.home.FlowerItemAdapter;
import com.example.flowerstore.ui.slideshow.CartItemAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class FavoriteItemAdapter extends RecyclerView.Adapter<FavoriteItemAdapter.FavoriteViewHolder>  {

    private List<Flower> favoriteFlowerList;
    private FavoriteViewHolder.ViewHolderListener listener;


    public FavoriteItemAdapter(List<Flower> favoriteFlowerList, FavoriteViewHolder.ViewHolderListener listener) {
        this.favoriteFlowerList = favoriteFlowerList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.favorite_item, parent, false);
        return new FavoriteItemAdapter.FavoriteViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoriteItemAdapter.FavoriteViewHolder holder, int position) {
        final Flower flower = favoriteFlowerList.get(position);
        holder.flowerFavoriteNameTv.setText(flower.getName());
        switch (flower.getName()) {
            case "Daisy":
                holder.flowerImageFavoriteIV.setImageResource(R.drawable.daisy);
                break;
            case "Rose":
                holder.flowerImageFavoriteIV.setImageResource(R.drawable.rose);
                break;
            case "Tulip":
                holder.flowerImageFavoriteIV.setImageResource(R.drawable.tulip);
                break;
            case "Lotus":
                holder.flowerImageFavoriteIV.setImageResource(R.drawable.lotus);
                break;
            default:
                holder.flowerImageFavoriteIV.setImageResource(R.drawable.ic_launcher_background);
        }

        holder.priceValueFavoriteTv.setText(flower.getPrice().toString());
        holder.flowerDescriptionValueTv.setText(flower.getDescription());
        holder.deleteFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flowerPosition = holder.getAdapterPosition();
                listener.onDeleteFavoriteItemButtonClicked(favoriteFlowerList.get(flowerPosition));
            }
        });



    }

    @Override
    public int getItemCount() {
        return favoriteFlowerList.size();
    }

    static class FavoriteViewHolder extends RecyclerView.ViewHolder {
        final ImageView flowerImageFavoriteIV;
        final TextView flowerFavoriteNameTv;
        final TextView priceFavoriteTv;
        final TextView priceValueFavoriteTv;
        final TextView flowerDescriptionTv;
        final TextView flowerDescriptionValueTv;
        final ImageButton deleteFavorite;

        public interface ViewHolderListener {
            void onDeleteFavoriteItemButtonClicked(Flower flower);
        }


        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            flowerImageFavoriteIV = itemView.findViewById(R.id.flower_image_favorite_iv);
            flowerFavoriteNameTv = itemView.findViewById(R.id.flower_favorite_name_tv);
            priceFavoriteTv = itemView.findViewById(R.id.price_favorite_tv);
            priceValueFavoriteTv = itemView.findViewById(R.id.price_value_favorite_tv);
            flowerDescriptionTv = itemView.findViewById(R.id.flower_description_tv);
            flowerDescriptionValueTv = itemView.findViewById(R.id.flower_description_value_tv);
            deleteFavorite = itemView.findViewById(R.id.delete_favorite_im);
        }
    }
}

