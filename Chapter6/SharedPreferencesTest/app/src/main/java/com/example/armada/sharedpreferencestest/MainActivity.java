package com.example.armada.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * 1. Context类中的getSharedPreferences()方法
     * 2. Activity类中的getPreferences()方法
     * 3. PreferenceManager类中的getDefaultSharedPreferences方法
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button savaData = (Button)findViewById(R.id.sava_data);
        savaData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // /data/data/com.example.sharedpreferencetest/shared_prefs/目录下
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });

        Button restoreData = (Button)findViewById(R.id.restore_data);
        restoreData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age",0);
                boolean married = pref.getBoolean("married",false);

                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();;
            }
        });
    }

}
