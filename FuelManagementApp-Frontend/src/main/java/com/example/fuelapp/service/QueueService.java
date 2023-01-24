package com.example.fuelapp.service;

import com.example.fuelapp.model.queue;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface QueueService {

    //get queue
    @GET("queue/")
    Call<List<queue>> getQueues();

    //post create
    @POST("queue/create")
    Call<queue> addToQueue(@Body queue queue);

    //put queue
    @PUT("queue/update/{id}")
    Call<queue> updateQueue(@Path("id") String id, @Body queue queue);

    //delete queue
    @DELETE("queue/delete/{id}")
    Call<queue> deleteFromQueue (@Path("id") String id);

    //get by id
    @GET("queue/queuedetails/{id}")
    Call<queue> getOneQueue (@Path("id") String id);

    @GET("queue/count/{id}")
    Call<List<queue>> getCountofQueue(@Path("id") String id);

    @GET("queue/count/petrol/{id}")
    Call<List<queue>> getCountofPetrolQueue(@Path("id") String id);

    @GET("queue/count/diesel/{id}")
    Call<List<queue>> getCountofDieselQueue(@Path("id") String id);

}
