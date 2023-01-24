package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fuelapp.model.queue;
import com.example.fuelapp.service.APIUtils;
import com.example.fuelapp.service.QueueService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueueView extends AppCompatActivity {

    Button btnAddQueue;
    Button btnGetQueuesList;
    ListView listView1;

    QueueService queueService;
    List<queue> list = new ArrayList<queue>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_view);

        btnAddQueue = (Button) findViewById(R.id.btnAddQueue);
        btnGetQueuesList = (Button) findViewById(R.id.btnGetQueuesList);
        listView1 = (ListView) findViewById(R.id.listView1);
        queueService = APIUtils.getQueueService();

        btnGetQueuesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get all queue list
                getQueuesList();

            }
        });

//        btnAddQueue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(QueueView.this, Queue.class);
//                intent.putExtra("flueCenterName", "");
//
//                startActivity(intent);
//            }
//        });


    }

    public void getQueuesList(){
        Call<List<queue>> call = queueService.getQueues();
        call.enqueue(new Callback<List<queue>>() {
            @Override
            public void onResponse(Call<List<queue>> call, Response<List<queue>> response) {
                if(response.isSuccessful()){
                    list  = response.body();
                    listView1.setAdapter(new QueueAdapter(QueueView.this, R.layout.list_queue, list));

                }
            }

            @Override
            public void onFailure(Call<List<queue>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}