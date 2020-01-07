package com.example.flowerstore.model.datasource;

import com.example.flowerstore.model.entity.Flower;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FlowerApi {

    @GET("/alungeipaula/FlowersStoreAndroid/master/FlowerStore/{fileName}")
    Call<List<Flower>> getFlowers(@Path("fileName") String jsonToFetch);
}
