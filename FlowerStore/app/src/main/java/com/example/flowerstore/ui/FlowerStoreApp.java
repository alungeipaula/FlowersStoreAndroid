package com.example.flowerstore.ui;

import android.app.Application;

import com.example.flowerstore.model.datasource.DataSource;
import com.example.flowerstore.provider.SharedPreferenceProvider;

public class FlowerStoreApp extends Application {


    private static final String key = "key";

    private DataSource dataSource = new DataSource();
    private SharedPreferenceProvider sharedPreferenceProvider;

    public DataSource getDataSource() {
        return dataSource;
    }

    public SharedPreferenceProvider getSharedPreferenceProvider() {
        return sharedPreferenceProvider;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferenceProvider = new SharedPreferenceProvider(this);
    }

}