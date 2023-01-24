package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//loginpage
public class LoginPage extends AppCompatActivity {

    EditText username1, password1;
    Button signin1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        signin1=findViewById(R.id.signin1);

        DB= new DBHelper(this);

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username1.getText().toString();
                String pass = password1.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                {
                    Toast.makeText(LoginPage.this, "All field Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}