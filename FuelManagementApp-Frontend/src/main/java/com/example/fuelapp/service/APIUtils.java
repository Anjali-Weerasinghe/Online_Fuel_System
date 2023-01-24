package com.example.fuelapp.service;

//Assigned API
public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://172.20.10.2:8070/";

    //call VehicleOwnerSevice class
    public static VehicleOwnerSevice getVehicleOwnerSevice(){
        return RetrofitV.getV(API_URL).create(VehicleOwnerSevice.class);
    }
    //call fuelAvailabilityService class
    public static fuelAvailabilityService getFuelAvailabilityService(){
        return RetrofitV.getV(API_URL).create(fuelAvailabilityService.class);
    }
    //call ReviewService class
    public static ReviewService getReviewSevice(){
        return RetrofitV.getV(API_URL).create(ReviewService.class);
    }

    //call QueueService class
    public static QueueService getQueueService(){
        return RetrofitV.getV(API_URL).create(QueueService.class);
    }
}
