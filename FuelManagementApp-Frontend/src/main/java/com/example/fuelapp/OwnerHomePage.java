package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//ownerHomePage
public class OwnerHomePage extends AppCompatActivity {

    Button details, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home_page);

        details = findViewById(R.id.details);
        search = findViewById(R.id.search);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StationView.class);
                startActivity(intent);
            }
        });


    }
}