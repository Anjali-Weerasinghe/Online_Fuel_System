package com.example.fuelapp.service;

import com.example.fuelapp.model.review;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ReviewService {

    //get review
    @GET("review/")
    Call<List<review>> getAllReviews();

    //post review
    @POST("review/create")
    Call<review> addReview(@Body review reviews);
}
