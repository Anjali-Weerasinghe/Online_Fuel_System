package com.example.fuelapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Fuel Availability Model

public class fuelAvailability {
    @SerializedName("_id")
    @Expose
    String id;

    @SerializedName("usernames")
    @Expose
    String usernames;

    @SerializedName("flueCenterId")
    @Expose
    String flueCenterId;

    @SerializedName("flueCenterName")
    @Expose
    String flueCenterName;

    @SerializedName("PetrolAvailable")
    @Expose
    String PetrolAvailable;

    @SerializedName("Dieselvailable")
    @Expose
    String Dieselvailable;

    @SerializedName("FinishlTime")
    @Expose
    String FinishlTime;

    @SerializedName("ArrivalTime")
    @Expose
    String ArrivalTime;

    public fuelAvailability() {
    }

    public fuelAvailability(String id, String usernames, String flueCenterId, String flueCenterName, String petrolAvailable, String dieselvailable, String finishlTime, String arrivalTime) {
        this.id = id;
        this.usernames = usernames;
        this.flueCenterId = flueCenterId;
        this.flueCenterName = flueCenterName;
        PetrolAvailable = petrolAvailable;
        Dieselvailable = dieselvailable;
        FinishlTime = finishlTime;
        ArrivalTime = arrivalTime;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernames() {
        return usernames;
    }

    public void setUsernames(String usernames) {
        this.usernames = usernames;
    }

    public String getFlueCenterId() {
        return flueCenterId;
    }

    public void setFlueCenterId(String flueCenterId) {
        this.flueCenterId = flueCenterId;
    }

    public String getFlueCenterName() {
        return flueCenterName;
    }

    public void setFlueCenterName(String flueCenterName) {
        this.flueCenterName = flueCenterName;
    }

    public String getPetrolAvailable() {
        return PetrolAvailable;
    }

    public void setPetrolAvailable(String petrolAvailable) {
        PetrolAvailable = petrolAvailable;
    }

    public String getDieselvailable() {
        return Dieselvailable;
    }

    public void setDieselvailable(String dieselvailable) {
        Dieselvailable = dieselvailable;
    }

    public String getFinishlTime() {
        return FinishlTime;
    }

    public void setFinishlTime(String finishlTime) {
        FinishlTime = finishlTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }
}
