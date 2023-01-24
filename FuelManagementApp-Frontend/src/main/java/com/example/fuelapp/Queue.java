package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuelapp.model.queue;
import com.example.fuelapp.model.vehicalOwner;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.QueueService;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Queue extends AppCompatActivity {

    QueueService queueService;
    EditText fcName, vId, owName, fType, inTime, outTime;
    Button btnSave, btnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);

        fcName = (EditText) findViewById(R.id.fcName);
        vId = (EditText) findViewById(R.id.vId);
        owName = (EditText) findViewById(R.id.owName);
        fType = (EditText) findViewById(R.id.fType);
        inTime = (EditText) findViewById(R.id.inTime);
        outTime = (EditText) findViewById(R.id.outTime);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDel = (Button) findViewById(R.id.btnDel);

        queueService = APIUtils.getQueueService();

        Bundle extras = getIntent().getExtras();
        String FCName = extras.getString("fcName");
        String vID = extras.getString("vId");
        String ownerName = extras.getString("ownerName");
        String fuelType = extras.getString("fuelType");
        String InTime = extras.getString("inTime");
        String OutTime = extras.getString("outTime");

        fcName.setText(FCName);
        vId.setText(vID);
        owName.setText(ownerName);
        fType.setText(fuelType);
        inTime.setText(InTime);
        outTime.setText(OutTime);

        if(vID != null && vID.trim().length() > 0 ){
            vId.setFocusable(false);
        } else{
            vId.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue qu = new queue();
                qu.setFcName(fcName.getText().toString());
                qu.setvId(vId.getText().toString());
                qu.setOwnerName(owName.getText().toString());
                qu.setFuelType(fType.getText().toString());
                qu.setInTime((Date) inTime.getText());
                qu.setOutTime((Date) outTime.getText());

                if(vID != null && vID.trim().length() > 0){
                    //update queue
                    updateQUeue(vID, qu);

                } else {
                    //add user
                    addTOQueue(qu);
                }

                Intent intent = new Intent(Queue.this, QueueView.class);
                startActivity(intent);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFRomQueue(vID);

                Intent intent = new Intent(Queue.this, QueueView.class);
                startActivity(intent);
            }
        });



    }

    public void addTOQueue (queue qu){
        Call<queue> call = queueService.addToQueue(qu);
        call.enqueue(new Callback<queue>() {
            @Override
            public void onResponse(Call<queue> call, Response<queue> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Queue.this, "Added to queue successfully", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<queue> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void updateQUeue (String id, queue qu){
        Call<queue> call = queueService.updateQueue(id, qu);
        call.enqueue(new Callback<queue>() {
            @Override
            public void onResponse(Call<queue> call, Response<queue> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Queue.this, "Queue updated successfully", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<queue> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void deleteFRomQueue (String id){
        Call<queue> call = queueService.deleteFromQueue(id);
        call.enqueue(new Callback<queue>() {
            @Override
            public void onResponse(Call<queue> call, Response<queue> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Queue.this, "Deleted from queue successfully", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<queue> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


}