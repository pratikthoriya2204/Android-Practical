package com.example.apiexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;  //create retrofit instance
    private static final String BASEURL = "https://jsonplaceholder.typicode.com/";  //pass base url of api

    public static Retrofit getRetrofit() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
