package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//ownerRegister
public class ownerRegister extends AppCompatActivity {

    EditText username4, password4, repassword4;
    Button signup4, signin4;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register);

        username4 = findViewById(R.id.username4);
        password4 = findViewById(R.id.password4);
        repassword4 = findViewById(R.id.repassword4);
        signin4 = findViewById(R.id.signin4);
        signup4 = findViewById(R.id.signup4);
        DB = new DBHelper(this);

        signup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username4.getText().toString();
                String pass = password4.getText().toString();
                String repass = repassword4.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(ownerRegister.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusernames(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertDatas(user,pass);
                            if (insert==true){
                                Toast.makeText(ownerRegister.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), ownerLogin.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(ownerRegister.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                            }
                        }else {
                            Toast.makeText(ownerRegister.this, "User already Exists", Toast.LENGTH_SHORT).show();

                        }

                    }else {
                        Toast.makeText(ownerRegister.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

        signin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ownerLogin.class);
                startActivity(intent);
            }
        });

    }
}