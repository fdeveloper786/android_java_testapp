package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        String html_data = "<h1>Secret agents</h1>\n" +
                "\n" +
                "<ul>\n" +
                "    <li data-id=\"10784\">Jason Walters, 003: Found dead in \"A View to a Kill\".</li>\n" +
                "    <li data-id=\"97865\">Alex Trevelyan, 006: Agent turned terrorist leader; James' nemesis in \"Goldeneye\".</li>\n" +
                "    <li data-id=\"45732\">James Bond, 007: The main man; shaken but not stirred.</li>\n" +
                "</ul>";
        Document document = Jsoup.parse(html_data);
        Elements elements = document.select("h1").select("li").select("body").select("body");
        Log.d("HTML Data",html_data);
        System.out.println("Html data" + html_data);
        Log.d("Parsed data ",elements.html());

    }
}