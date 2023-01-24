package com.example.fuelapp.service;

import com.example.fuelapp.model.fuelAvailability;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface fuelAvailabilityService {

    @GET("availability/")
    Call<List<fuelAvailability>> getfuelAvailability();

    @POST("availability/create")
    Call<fuelAvailability> addfuelAvailability(@Body fuelAvailability fuelavailability);

    @PUT("availability/update/{id}")
    Call<fuelAvailability> updatefuelAvailability(@Path("id") String id, @Body fuelAvailability fuel);

    @DELETE("availability/delete/{id}")
    Call<fuelAvailability> deletefuelAvailability (@Path("id") String id);

    @GET("availability/search/{id}")
    Call<List<fuelAvailability>> searchCenter(@Path("id") String id);
}
