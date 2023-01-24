package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fuelapp.model.review;
import com.example.fuelapp.model.vehicalOwner;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//view Reviews
public class ViewReviews extends AppCompatActivity {

    Button btnAddReview;
    Button btnGetReviewList;
    ListView listReview;
    ReviewService reviewService;

    List<review> list = new ArrayList<review>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reviews);

        btnAddReview = (Button) findViewById(R.id.btnAddReview);
        btnGetReviewList = (Button) findViewById(R.id.btnGetReviewList);
        listReview = (ListView) findViewById(R.id.listReview);
        reviewService = APIUtils.getReviewSevice();

        btnGetReviewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get List of Review
                getReviewList();
            }
        });
//btn call
        btnAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewReviews.this, ReviewRegistry.class);
                intent.putExtra("reviewerId", "");
                startActivity(intent);
            }
        });
    }

    //get
    public void getReviewList(){
        Call<List<review>> call = reviewService.getAllReviews();
        call.enqueue(new Callback<List<review>>() {
            @Override
            public void onResponse(Call<List<review>> call, Response<List<review>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listReview.setAdapter(new ReviewAdapter(ViewReviews.this, R.layout.list_review, list));

                }
            }

            @Override
            public void onFailure(Call<List<review>> call, Throwable t) {

                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}