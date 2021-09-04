package com.example.rantsonli;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.rantsonli.Models.Users;
import com.example.rantsonli.databinding.ActivityDetailedactivityBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class detailedactivity extends AppCompatActivity {
    ActivityDetailedactivityBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailedactivity);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lottieAnimationView = findViewById(R.id.splashcircle);
        binding = ActivityDetailedactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        binding.Signup.setOnClickListener(v -> {
            auth.createUserWithEmailAndPassword(binding.email.getText().toString(), binding.password.getText().toString()).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {

                    Users user = new Users(binding.email.getText().toString(), binding.password.getText().toString());
                    String id = (Objects.requireNonNull(task.getResult().getUser())).getUid();
                    database.getReference().child("Users").child(id).setValue(user);
                    Toast.makeText(detailedactivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();

                    binding.login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            lottieAnimationView.setVisibility(View.VISIBLE);
                            lottieAnimationView.playAnimation();
                            Thread td = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        sleep(1000);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();

                                    } finally {
                                        Intent intent = new Intent(detailedactivity.this, login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            };td.start();
                        }
                    });

                } else {
                    Toast.makeText(detailedactivity.this, (Objects.requireNonNull(task.getException())).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}