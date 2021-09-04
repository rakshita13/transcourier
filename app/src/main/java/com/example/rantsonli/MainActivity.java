package com.example.rantsonli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Button button;
    TextView textView5,textView6, textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lottieAnimationView = findViewById(R.id.splashcircle);
        button = findViewById(R.id.button);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                lottieAnimationView.playAnimation();
                textView5.setVisibility(View.INVISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);

                Thread td = new Thread(){
                    @Override
                    public void run() {
                        try{
                            sleep(1000);
                            new AssertionError();
                        }catch(Exception ex){
                            ex.printStackTrace();

                        }finally{
                            Intent intent = new Intent(MainActivity.this,detailedactivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };td.start();
            }
        });

    }


}