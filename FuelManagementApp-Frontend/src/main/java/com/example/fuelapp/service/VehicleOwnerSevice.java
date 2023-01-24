package com.example.fuelapp.service;

import com.example.fuelapp.model.vehicalOwner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface VehicleOwnerSevice {

    //get owner
    @GET("owner/")
    Call<List<vehicalOwner>> getvehicleOwners();

    //post owner
    @POST("owner/create")
    Call<vehicalOwner> addVehicle(@Body vehicalOwner vehicalowner);

    //update owner
    @PUT("owner/update/{id}")
    Call<vehicalOwner> updateVehicle(@Path("id") String id, @Body vehicalOwner vehicle);

    //delete owner
    @DELETE("owner/delete/{id}")
    Call<vehicalOwner> deleteVehicle (@Path("id") String id);


}
