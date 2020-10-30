package com.example.hotrovn.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hotrovn.utilities.model.country.Country;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ReadJsonFile {

    private Context context;

    public ReadJsonFile(Context context) {
        this.context = context;
    }

    // đọc File Json và chuyển sang kiểu String
    private String readFileLocation( String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }

    // add file vừa đọc vào Model
    public List<Country> parseFileLocation() {
        String jsonString = readFileLocation( "data.json");
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Country>>() {
        }.getType();
        List<Country> countryList = gson.fromJson(jsonString, listType);
        return countryList;
    }


    public void saveSharedPreferencesCountry(Country country) {
        Gson gson = new Gson();
        String json_country = gson.toJson(country);
        SharedPreferences prefs = context.getSharedPreferences("CountrySharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("Country", json_country);
        edit.commit();
    }

    public Country readSharedPreferencesCountry() {
        Gson gson = new Gson();
        SharedPreferences prefs = context.getSharedPreferences("CountrySharedPreferences", MODE_PRIVATE);
        String json = prefs.getString("Country", "");
        Country country = gson.fromJson(json, Country.class);
        return country;
    }
}
