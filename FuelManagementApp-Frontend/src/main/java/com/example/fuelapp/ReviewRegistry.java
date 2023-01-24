package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuelapp.model.review;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.ReviewService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//Review Registry
public class ReviewRegistry extends AppCompatActivity {

    ReviewService reviewService;
    EditText idd, txt2, txt3, txt4;
    Button btnreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        idd = (EditText) findViewById(R.id.idd);
        txt2 = (EditText) findViewById(R.id.txt2);
        txt3 = (EditText) findViewById(R.id.txt3);
        txt4 = (EditText) findViewById(R.id.txt4);
        btnreview = (Button) findViewById(R.id.btnreview);

        reviewService = APIUtils.getReviewSevice();

        Bundle extras = getIntent().getExtras();
        String reviewer_Id = extras.getString("reviewerId");
        String flueCenter_Id = extras.getString("flueCenterId");
        String flueCenter_Name = extras.getString("flueCenterName");
        String R_Comment = extras.getString("Comment");

        idd.setText(reviewer_Id);
        txt2.setText(flueCenter_Id);
        txt3.setText(flueCenter_Name);
        txt4.setText(R_Comment);

        btnreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                review r = new review();
                r.setReviewerId(idd.getText().toString());
                r.setFlueCenterId(txt2.getText().toString());
                r.setFlueCenterName(txt3.getText().toString());
                r.setComment(txt4.getText().toString());

                addReviews(r);


            }
        });
    }

    public void addReviews (review r){
        Call<review> call = reviewService.addReview(r);
        call.enqueue(new Callback<review>() {
            @Override
            public void onResponse(Call<review> call, Response<review> response) {
                if(response.isSuccessful()){
                    Toast.makeText(ReviewRegistry.this, "Review added successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<review> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}