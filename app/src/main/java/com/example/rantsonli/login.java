package com.example.rantsonli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button = findViewById(R.id.next1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread td = new Thread(){
                    @Override
                    public void run() {
                        try{
                            sleep(1000);
                        }catch(Exception ex){
                            ex.printStackTrace();

                        }finally{
                            Intent intent = new Intent(login.this,Tenantinfo.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };td.start();
            }
        });

    }
}