package com.example.fuelapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Review Model
public class review {

    @SerializedName("reviewerId")
    @Expose
    String reviewerId;

    @SerializedName("flueCenterId")
    @Expose
    String flueCenterId;

    @SerializedName("flueCenterName")
    @Expose
    String flueCenterName;

    @SerializedName("Comment")
    @Expose
    String Comment;

    public review() {
    }

    public review(String reviewerId, String flueCenterId, String flueCenterName, String comment) {
        this.reviewerId = reviewerId;
        this.flueCenterId = flueCenterId;
        this.flueCenterName = flueCenterName;
        Comment = comment;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
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

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
