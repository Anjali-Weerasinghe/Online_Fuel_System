package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fuelapp.model.fuelAvailability;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.fuelAvailabilityService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//station view
public class StationView extends AppCompatActivity {

    Button btnstation, btnFetchStation;
    ListView stationlistView;
    fuelAvailabilityService fuelavailabilityservice;

    List<fuelAvailability> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_view);

        btnstation = (Button) findViewById(R.id.btnstation);
        btnFetchStation = (Button) findViewById(R.id.btnFetchStation);
        stationlistView = (ListView) findViewById(R.id.stationlistView);
        fuelavailabilityservice = APIUtils.getFuelAvailabilityService();

        btnFetchStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get station list
                getStationList();

            }
        });


        btnstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StationView.this, Station.class);
                intent.putExtra("usernames", "");
                startActivity(intent);
            }
        });
    }

    //get station
    public void getStationList(){
        Call<List<fuelAvailability>> call = fuelavailabilityservice.getfuelAvailability();
        call.enqueue(new Callback<List<fuelAvailability>>() {
            @Override
            public void onResponse(Call<List<fuelAvailability>> call, Response<List<fuelAvailability>> response) {
                list = response.body();
                stationlistView.setAdapter(new StationAdapter(StationView.this, R.layout.list_station, list));
            }

            @Override
            public void onFailure(Call<List<fuelAvailability>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());

            }
        });

    }
}