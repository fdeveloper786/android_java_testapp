package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     ImageButton btnCheck,btnShare;
     Button btnRecycler,btnVolley,btnHtmlData,btnSocket;
     TextView txtHtmlData;

    private int seconds = 30;
     private boolean stopTimer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck =findViewById(R.id.btnCheck);
        btnShare = findViewById(R.id.btnShare);
        btnRecycler = findViewById(R.id.btnRecyclerView);
        btnVolley = findViewById(R.id.btnVolley);
        btnHtmlData = findViewById(R.id.btnSplash);
        txtHtmlData = findViewById(R.id.txtHtmlData);
        btnSocket = findViewById(R.id.btnWebSocket);

        btnSocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,WebSocketApp.class);
                startActivity(i);
            }
        });

        btnHtmlData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SplashScreen.class);
                startActivity(i);
            }
        });

        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Volley_Activity.class);
                startActivity(i);
            }
        });

        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Recycler_Activity.class);
                startActivity(i);
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Check Button Pressed",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,Score.class);
                timer();
                //startActivity(i);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Share Button Pressed",Toast.LENGTH_SHORT).show();
               Intent i = new Intent(MainActivity.this,home.class);
               startActivity(i);

            }
        });
    }

    private void timer() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(seconds < 0) {
                    seconds--;
                    //handler.postDelayed(this,1000);
                    stopTimer = true;

                    handler.postDelayed(this,1000);
                    System.out.println("time is " + seconds);

                }
                if(stopTimer == false) {
                    handler.postDelayed(this,1000);
                }
            }
        });
    }
}