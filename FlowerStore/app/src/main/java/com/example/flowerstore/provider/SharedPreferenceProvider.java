package com.example.flowerstore.provider;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class SharedPreferenceProvider {
    private SharedPreferences sharedPref;

    private String usernameKey = "usernameKey";
    private String favoritePersonNameKey = "favoritePersonNameKey";
    private String favoritePersonAddressKey = "favoritePersonAddressKey";
    private String profilePictureKey = "profilePictureKey";

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

    public void saveFavoritePersonName(String favoritePersonName) {
        sharedPref.edit().putString(favoritePersonNameKey, favoritePersonName).apply();
    }

    public String loadFavoritePersonName() {
        return sharedPref.getString(favoritePersonNameKey, "");
    }

    public void saveFavoritePersonAddress(String favoritePersonAddress) {
        sharedPref.edit().putString(favoritePersonAddressKey, favoritePersonAddress).apply();
    }

    public String loadFavoritePersonAddress() {
        return sharedPref.getString(favoritePersonAddressKey, "");
    }

    public void saveSharedPrefPicture(Bitmap bitmap) {
        sharedPref.edit().putString(profilePictureKey, BitMapToString(bitmap)).apply();
    }

    public Bitmap loadSharedPrefPicture() {
        String bitmapString = sharedPref.getString(profilePictureKey, null);
        return StringToBitMap(bitmapString);
    }


    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    //save
    //load
}
