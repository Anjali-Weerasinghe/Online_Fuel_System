package com.example.fuelapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Create Retrofit Client file
//reference: https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
public class RetrofitV {

    private static Retrofit retrofit = null;

    public static Retrofit getV (String url) {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
