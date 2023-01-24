package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fuelapp.service.fuelAvailabilityService;

import com.example.fuelapp.model.fuelAvailability;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//searchView
public class searchView extends AppCompatActivity {

    EditText centername;
    Button btnqueue, search1;
    ListView searchList;
    fuelAvailabilityService fuelavailabilityService;

    List<fuelAvailability> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        btnqueue = (Button) findViewById(R.id.btnqueue);
        search1 = (Button) findViewById(R.id.search1);
        centername = (EditText) findViewById(R.id.centername);
        searchList = (ListView) findViewById(R.id.searchList);

        btnqueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), QueueView.class);
//                startActivity(intent);

            }
        });
//search onclick
        search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String flueCenterName = centername.getText().toString();

            }
        });
    }

    //search
    public void searchCenterName (String id){
        Call<List<fuelAvailability>> call = fuelavailabilityService.searchCenter(id);
        call.enqueue(new Callback<List<fuelAvailability>>() {
            @Override
            public void onResponse(Call<List<fuelAvailability>> call, Response<List<fuelAvailability>> response) {
                if(response.isSuccessful()){
                    list = response.body();

                }
            }

            @Override
            public void onFailure(Call<List<fuelAvailability>> call, Throwable t) {

            }
        });

    }
}