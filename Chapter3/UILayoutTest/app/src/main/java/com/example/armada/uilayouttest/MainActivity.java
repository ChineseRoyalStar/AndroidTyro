package com.example.armada.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button linearlayout = (Button)findViewById(R.id.linearlayout_button);
        linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button relativelayout = (Button)findViewById(R.id.relativelayout_button);
        relativelayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button framelayout = (Button)findViewById(R.id.framelayout_button);
        framelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FrameLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button percentFrameLayout = (Button)findViewById(R.id.percentframelayout_button);
        percentFrameLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PercentFrameLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
