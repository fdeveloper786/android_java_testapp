package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketApp extends AppCompatActivity {
    private Button start;
    private TextView output;
    private OkHttpClient client;

    private final class EchoWebSocketListener extends WebSocketListener {
        private static final int NORMAL_CLOSURE_STATUS = 1000;
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            webSocket.send("Hello,I am Jawed !");
            webSocket.send("Web Socket Working");
            webSocket.send(ByteString.decodeHex("deedbeef"));
            webSocket.close(NORMAL_CLOSURE_STATUS, "Good bye socket !");
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
            output("Receiving : " + text);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
            output("Receiving bytes : "+ bytes.hex());
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
            webSocket.close(NORMAL_CLOSURE_STATUS,null);
            output("Closing: " + code+ "/"+reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t,Response response) {
            super.onFailure(webSocket, t, response);
            output("Error : "+ t.getMessage());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_socket_app);
        start = (Button) findViewById(R.id.btnStart);
        output = (TextView) findViewById(R.id.txtSocket);
        client = new OkHttpClient();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
    }
    private void start() {
        String url = "wss://connect.websocket.in/v3/1?api_key=VCXCEuvhGcBDP7XhiJJUDvR1e1D3eiVjgZ9VRiaV&notify_self";
        Request request = new Request.Builder().url(url).build();
        EchoWebSocketListener listener = new EchoWebSocketListener();
        WebSocket ws = client.newWebSocket(request,listener);
        client.dispatcher().executorService().shutdown();
    }

    private void output(final String txt) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                output.setText(output.getText().toString() + "\n\n" + txt);
            }
        });
    }
}