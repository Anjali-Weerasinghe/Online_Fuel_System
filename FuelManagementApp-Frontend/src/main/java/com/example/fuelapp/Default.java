package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fuelapp.model.vehicalOwner;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.VehicleOwnerSevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//vehicle owner implementation
public class Default extends AppCompatActivity {

    Button btnAddUser;
    Button btnGetUsersList;
    ListView listView;
    VehicleOwnerSevice vehicleOwnerSevice;

    List<vehicalOwner> list = new ArrayList<vehicalOwner>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        btnAddUser = (Button) findViewById(R.id.btnAddUser);
        btnGetUsersList = (Button) findViewById(R.id.btnGetUsersList);
        listView = (ListView) findViewById(R.id.listView);
        vehicleOwnerSevice = APIUtils.getVehicleOwnerSevice();

        btnGetUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get vehicle list
                getVehicleList();
            }
        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Default.this, VehicleRegistry.class);
                intent.putExtra("ownerName", "");
                startActivity(intent);
            }
        });
    }
     public void getVehicleList(){
         Call<List<vehicalOwner>> call = vehicleOwnerSevice.getvehicleOwners();
         call.enqueue(new Callback<List<vehicalOwner>>() {
             @Override
             public void onResponse(Call<List<vehicalOwner>> call, Response<List<vehicalOwner>> response) {
                 if(response.isSuccessful()){
                     list = response.body();
                     listView.setAdapter(new VehicleAdapter(Default.this, R.layout.list_vehicle, list));

                 }
             }

             @Override
             public void onFailure(Call<List<vehicalOwner>> call, Throwable t) {

                 Log.e("ERROR: ", t.getMessage());
             }
         });
     }
}