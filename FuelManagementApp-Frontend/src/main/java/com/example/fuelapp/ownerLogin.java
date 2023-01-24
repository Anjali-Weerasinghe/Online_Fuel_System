package com.example.fuelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//ownerLogin
public class ownerLogin extends AppCompatActivity {

    EditText username2, password2;
    Button signin3;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        username2 = findViewById(R.id.username2);
        password2 = findViewById(R.id.password2);
        signin3 = findViewById(R.id.signin3);

        DB = new DBHelper(this);

        signin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username2.getText().toString();
                String pass = password2.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                {
                    Toast.makeText(ownerLogin.this, "All field Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass=DB.checkusernamepasswords(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(ownerLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), OwnerHomePage.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ownerLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}