package com.example.rantsonli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class tsignature extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsignature);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button = findViewById(R.id.tsignature);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread td = new Thread(){
                    @Override
                    public void run() {
                        try{
                            sleep(1000);
                            new AssertionError();
                        }catch(Exception ex){
                            ex.printStackTrace();

                        }finally{
                            Intent intent = new Intent(tsignature.this,tsignaturepad.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };td.start();
            }
        });

    }
}