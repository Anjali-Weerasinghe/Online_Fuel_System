package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuelapp.model.fuelAvailability;
import com.example.fuelapp.model.vehicalOwner;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.fuelAvailabilityService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Station extends AppCompatActivity {

    fuelAvailabilityService fuelavailabilityService;
    EditText fID, fusername, fuelID, fname, pava, davail, timef, timea;
    Button fuelAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        fID = (EditText) findViewById(R.id.fID);
        fusername = (EditText) findViewById(R.id.fusername);
        fuelID = (EditText) findViewById(R.id.fuelID);
        fname = (EditText) findViewById(R.id.fname);
        pava = (EditText) findViewById(R.id.pava);
        davail = (EditText) findViewById(R.id.davail);
        timef = (EditText) findViewById(R.id.timef);
        timea = (EditText) findViewById(R.id.timea);
        fuelAdd = (Button) findViewById(R.id.fuelAdd);

        fuelavailabilityService = APIUtils.getFuelAvailabilityService();

        Bundle extras = getIntent().getExtras();
        final String ffID = extras.getString("fuID");
        String ffusername = extras.getString("usernames");
        String ffuelID = extras.getString("flueCenterId");
        String ffname = extras.getString("flueCenterName");
        String fpava = extras.getString("PetrolAvailable");
        String fdavail = extras.getString("Dieselvailable");
        String ftimef = extras.getString("FinishlTime");
        String ftimea = extras.getString("ArrivalTime");

        fID.setText(ffuelID);
        fusername.setText(ffusername);
        fuelID.setText(ffID);
        fname.setText(ffname);
        pava.setText(fpava);
        davail.setText(fdavail);
        timef.setText(ftimef);
        timea.setText(ftimea);

        //add
        fuelAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fuelAvailability fa = new fuelAvailability();

                fa.setUsernames(fusername.getText().toString());
                fa.setFlueCenterId(fID.getText().toString());
                fa.setFlueCenterName(fname.getText().toString());
                fa.setPetrolAvailable(pava.getText().toString());
                fa.setDieselvailable(davail.getText().toString());
                fa.setFinishlTime(timef.getText().toString());
                fa.setArrivalTime(timea.getText().toString());

                if(ffID != null && ffID.trim().length() > 0) {

                    updateStation(ffID, fa);
                }
                else {

                    addStation(fa);

                }

            }
        });

    }

    //add
    public void addStation (fuelAvailability fa){
        Call<fuelAvailability> call = fuelavailabilityService.addfuelAvailability(fa);
        call.enqueue(new Callback<fuelAvailability>() {
            @Override
            public void onResponse(Call<fuelAvailability> call, Response<fuelAvailability> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Station.this, "Station created successfully", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<fuelAvailability> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }

    //update
    public void updateStation (String id, fuelAvailability fa){
        Call<fuelAvailability> call = fuelavailabilityService.updatefuelAvailability(id, fa);
        call.enqueue(new Callback<fuelAvailability>() {
            @Override
            public void onResponse(Call<fuelAvailability> call, Response<fuelAvailability> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Station.this, "station updated successfully", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<fuelAvailability> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());

            }
        });
    }

    //delete
    public void deleteStation (String id){
        Call<fuelAvailability> call = fuelavailabilityService.deletefuelAvailability(id);
        call.enqueue(new Callback<fuelAvailability>() {
            @Override
            public void onResponse(Call<fuelAvailability> call, Response<fuelAvailability> response) {
                Toast.makeText(Station.this, "Station deleted successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<fuelAvailability> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}