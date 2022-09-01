package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Volley_Activity extends AppCompatActivity {
    ImageView imgProfile,img2;

    private static final String URL = "https://api.github.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        RecyclerView userList = (RecyclerView) findViewById(R.id.userListCard);
        //userList.setLayoutManager(new LinearLayoutManager(this));

        imgProfile = findViewById(R.id.imgProfile);
        img2 = findViewById(R.id.img2);
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
        String[] imageList = {"https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=800",
        "https://images.pexels.com/photos/14401/pexels-photo-14401.jpeg?auto=compress&cs=tinysrgb&w=800"};

              @Override
            public void onResponse(String response) {
                Log.d("CODE",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                User[] users = gson.fromJson(response,User[].class);
                //userList.setAdapter(new ImageListAdapter(Volley_Activity.this,users));

                for(int i =0;i<users.length;i++) {
                    System.out.println("My Gson Response:" + users[i].getLogin());
                }
                  Glide.with(Volley_Activity.this).load(imageList[0]).into(imgProfile);
                  Glide.with(Volley_Activity.this).load(imageList[1]).into(img2);

              }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Volley_Activity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                }
                );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}