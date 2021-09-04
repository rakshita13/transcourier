package com.example.rantsonli;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class tsignaturepad extends AppCompatActivity {
    GestureOverlayView gestureView;
    String path;
    File file;
    Bitmap bitmap;
    Button button;
    public boolean gestureTouch=false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tsignaturepad);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button donebutton = (Button) findViewById(R.id.DoneButton);
        donebutton.setText("Done");
        Button clearButton = (Button) findViewById(R.id.ClearButton);
        clearButton.setText("Clear");
        button = findViewById(R.id.nextonli);
        path = Environment.getExternalStorageDirectory() + "/signature.png";
        file = new File(path);
        file.delete();
        gestureView = (GestureOverlayView) findViewById(R.id.signaturePad);
        gestureView.setDrawingCacheEnabled(true);

        gestureView.setAlwaysDrawnWithCacheEnabled(true);
        gestureView.setHapticFeedbackEnabled(false);
        gestureView.cancelLongPress();
        gestureView.cancelClearAnimation();
        gestureView.addOnGestureListener(new GestureOverlayView.OnGestureListener() {
            @Override
            public void onGestureStarted(GestureOverlayView arg0, MotionEvent arg1) {
                gestureTouch= arg1.getAction() != MotionEvent.ACTION_MOVE;
            }

            @Override
            public void onGesture(GestureOverlayView arg0, MotionEvent arg1) {

            }

            @Override
            public void onGestureEnded(GestureOverlayView arg0, MotionEvent arg1) {

            }

            @Override
            public void onGestureCancelled(GestureOverlayView arg0, MotionEvent arg1) {

            }
        });

        donebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bitmap = Bitmap.createBitmap(gestureView.getDrawingCache());
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    fos = new FileOutputStream(file);
                    // compress to specified format (PNG), quality - which is
                    // ignored for PNG, and out stream
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(gestureTouch==false)
                {
                    setResult(0);
                    finish();
                }
                else
                {
                    setResult(1);
                    finish();
                }
            }
        });



        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                gestureView.invalidate();
                gestureView.clear(true);
                gestureView.clearAnimation();
                gestureView.cancelClearAnimation();
            }
        });
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
                            Intent intent = new Intent(tsignaturepad.this,lastactivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };td.start();
            }
        });

    }



}