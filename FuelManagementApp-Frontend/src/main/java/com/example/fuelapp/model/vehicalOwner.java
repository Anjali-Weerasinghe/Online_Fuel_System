package com.example.fuelapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//vehicle owner model
public class vehicalOwner {

    @SerializedName("_id")
    @Expose
    String id;

    @SerializedName("ownerName")
    @Expose
    String ownerName;

    @SerializedName("VechicalId")
    @Expose
    String VechicalId;

    @SerializedName("fuelType")
    @Expose
    String fuelType;

    public vehicalOwner() {

    }

    public vehicalOwner(String id, String ownerName, String vechicalId, String fuelType) {
        this.id = id;
        this.ownerName = ownerName;
        VechicalId = vechicalId;
        this.fuelType = fuelType;
    }
//getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVechicalId() {
        return VechicalId;
    }

    public void setVechicalId(String vechicalId) {
        VechicalId = vechicalId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
