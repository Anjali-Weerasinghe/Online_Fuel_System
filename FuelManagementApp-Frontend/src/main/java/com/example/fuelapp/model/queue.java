package com.example.fuelapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

//Queue Model
public class queue {

    @SerializedName("flueCenterName")
    @Expose
    String flueCenterName;

    @SerializedName("vehicleId")
    @Expose
    String vehicleId;

    @SerializedName("OwnerName")
    @Expose
    String OwnerName;

    @SerializedName("fuelType")
    @Expose
    String fuelType;

    @SerializedName("inTime")
    @Expose
    Date inTime;

    @SerializedName("outTime")
    @Expose
    Date outTime;


    public queue() {

    }

    public queue(String flueCenterName, String vehicleId, String OwnerName, String fuelType, Date inTime, Date outTime) {
        this.flueCenterName = flueCenterName;
        this.vehicleId = vehicleId;
        this.OwnerName = OwnerName;
        this.fuelType = fuelType;
        this.inTime = inTime;
        this.outTime = outTime;
        //this.waitingTime = waitingTime;
    }

    //getters and setters
    public String getFcName() {
        return flueCenterName;
    }

    public void setFcName(String flueCenterName) {
        this.flueCenterName = flueCenterName;
    }

    public String getvId() {
        return vehicleId;
    }

    public void setvId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }


}
