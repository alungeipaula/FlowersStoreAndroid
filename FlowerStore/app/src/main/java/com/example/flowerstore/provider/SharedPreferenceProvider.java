package com.example.flowerstore.provider;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceProvider {
    private SharedPreferences sharedPref;

    private String usernameKey = "usernameKey";
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

    //save
    //load
}
