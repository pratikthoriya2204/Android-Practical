package com.example.apipractice2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<PostPOJO>> getPost();
}
