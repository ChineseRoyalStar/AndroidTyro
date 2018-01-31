package com.example.armada.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intetnFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        intetnFilter = new IntentFilter();
        intetnFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intetnFilter);*/

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
               // sendBroadcast(intent);
                sendBroadcast(intent,null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    //定义内部类,继承自BroadcastReceiver, 并重写了父类的onReceive()方法. 这样每当网络状态发生改变时, onReceive()方法就会得到执行
    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
           // Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
            ConnectivityManager connectionManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
