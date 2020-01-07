package com.example.flowerstore.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flowerstore.R;
import com.example.flowerstore.model.datasource.FlowerApi;
import com.example.flowerstore.model.entity.Flower;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeText;
    ImageView welcomeImage;
    Button checkItOutButton;

    private static final String TAG = WelcomeActivity.class.getSimpleName();
    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private List<Flower> flowersList = new ArrayList<Flower>();
    private static Retrofit retrofit;

    public List<Flower> getFlowersList() {
        return flowersList;
    }

    public WelcomeActivity() {
        this.flowersList = getFlowersList();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();

        checkItOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, NavigationActivity.class);
                startActivity(intent);

            }
        });


        FlowerApi api = getRetrofit().create(FlowerApi.class);
        Log.d("my tag", api.toString());
        Call<List<Flower>> persons = api.getFlowers("flowers_sources_jsons");
        persons.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().toString());
                    List<Flower> flowers = response.body();

                    for (Flower flower : flowers) {
                        flowersList.add(flower);
                        //TODO AICI
                        ((FlowerStoreApp) getApplication()).getDataSource().setFlowers(flowersList);
                        Log.d(TAG, "Flower name: " + flower.getName());
                    }
                } else {

                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                Log.w("Response", "Error in call", t.getCause());
            }
        });

    }

    private void initViews() {
        welcomeText = findViewById(R.id.welcome_text);
        welcomeImage = findViewById(R.id.welcome_image);
        checkItOutButton = findViewById(R.id.welcome_button);
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
