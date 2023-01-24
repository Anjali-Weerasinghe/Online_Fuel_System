package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuelapp.model.vehicalOwner;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.VehicleOwnerSevice;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleRegistry extends AppCompatActivity {

    VehicleOwnerSevice vehicleOwnerSevice;
    EditText ownername, vehiId, fuelType, idd;
    Button signin1, btnDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_registry);


        ownername = (EditText) findViewById(R.id.ownername);
        vehiId = (EditText) findViewById(R.id.vehiId);
        fuelType = (EditText) findViewById(R.id.fuelType);
        signin1 = (Button) findViewById(R.id.signin1);
        idd = (EditText) findViewById(R.id.idd);
        btnDel = (Button) findViewById(R.id.btnDel);

        vehicleOwnerSevice = APIUtils.getVehicleOwnerSevice();

        Bundle extras = getIntent().getExtras();
        final String Rid = extras.getString("Vid");
        String owner_name = extras.getString("ownerName");
        String vehi_Id = extras.getString("VechicalId");
        String fuel_Type = extras.getString("fuelType");


        ownername.setText(owner_name);
        vehiId.setText(vehi_Id);
        fuelType.setText(fuel_Type);
        idd.setText(Rid);


//        if(owner_name != null && owner_name.trim().length() > 0 ){
//            ownername.setFocusable(false);
//        }
//        else {
//
//        }

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vehicalOwner vo = new vehicalOwner();
                //vo.setId(idd.getText().toString());
                vo.setOwnerName(ownername.getText().toString());
                vo.setVechicalId(vehiId.getText().toString());
                vo.setFuelType(fuelType.getText().toString());

                if(Rid != null && Rid.trim().length() > 0) {

                    updateVehicle(Rid, vo);
                }
                else {
                    //add vehicle
                    addVehicle(vo);

                }
            }
        });
//delete
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteVehicle(Rid);

                Intent intent = new Intent(VehicleRegistry.this, Default.class);
                startActivity(intent);
            }
        });
    }


//add
    public void addVehicle (vehicalOwner vo){
        Call<vehicalOwner> call = vehicleOwnerSevice.addVehicle(vo);
        call.enqueue(new Callback<vehicalOwner>() {
            @Override
            public void onResponse(Call<vehicalOwner> call, Response<vehicalOwner> response) {
                if(response.isSuccessful()){
                    Toast.makeText(VehicleRegistry.this, "Vehicle created successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<vehicalOwner> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
//update
    public void updateVehicle (String id, vehicalOwner vo){
        Call<vehicalOwner> call = vehicleOwnerSevice.updateVehicle(id, vo);
        call.enqueue(new Callback<vehicalOwner>() {
            @Override
            public void onResponse(Call<vehicalOwner> call, Response<vehicalOwner> response) {
                if(response.isSuccessful()){
                    Toast.makeText(VehicleRegistry.this, "Vehicle updated successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<vehicalOwner> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
//delete
    public void deleteVehicle (String id){
        Call<vehicalOwner> call = vehicleOwnerSevice.deleteVehicle(id);
        call.enqueue(new Callback<vehicalOwner>() {
            @Override
            public void onResponse(Call<vehicalOwner> call, Response<vehicalOwner> response) {
                if(response.isSuccessful()){
                    Toast.makeText(VehicleRegistry.this, "Vehicle deleted successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<vehicalOwner> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}