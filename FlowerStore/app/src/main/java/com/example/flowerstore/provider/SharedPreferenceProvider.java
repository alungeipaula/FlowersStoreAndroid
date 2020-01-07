package com.example.flowerstore.provider;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceProvider {
    private SharedPreferences sharedPref;

    private String usernameKey = "usernameKey";
    private String favoritePersonNameKey = "favoritePersonNameKey";
    private String favoritePersonAddressKey = "favoritePersonAddressKey";

    //cheie noua

    public SharedPreferenceProvider(Context context) {
        sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
    }

    public void saveUsername(String userName) {
        sharedPref.edit().putString(usernameKey, userName).apply();
    }

    public String loadUsername() {
        return sharedPref.getString(usernameKey, "");//default value
    }

    public void saveFavoritePersonName(String favoritePersonName){
        sharedPref.edit().putString(favoritePersonNameKey, favoritePersonName).apply();
    }

    public String loadFavoritePersonName(){
        return sharedPref.getString(favoritePersonNameKey,"");
    }

    public void saveFavoritePersonAddress(String favoritePersonAddress){
        sharedPref.edit().putString(favoritePersonAddressKey, favoritePersonAddress).apply();
    }

    public String loadFavoritePersonAddress(){
       return  sharedPref.getString(favoritePersonAddressKey, "");
    }
    //save
    //load
}
