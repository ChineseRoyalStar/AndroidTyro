package com.example.armada.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You Clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You Clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
                //finish();

                /** 1.显示Intent
                 * Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                 */


                /** 2.隐式Intent
                 *  Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                 *  intent.addCategory("android.intent.category.MY_CATEGORY");
                 *  startActivity(intent);
                 */

                /** 更多隐式Intent
                 *  Intent intent = new Intent(Intent.ACTION_VIEW);
                 *  intent.setData(Uri.parse("https://baidu.com"));
                 *  startActivity(intent);
                 *
                 *  Intent intent = new Intent(Intent.ACTION_DIAL);
                 *  intent.setData(Uri.parse("tel:10086"));
                 *  startActivity(intent);
                 */

                /** 向下一个活动传递数据
                 *  String data = "Hello SecondActivity";
                 *  Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                 *  intent.putExtra("extra_data",data);
                 *  startActivity(intent);
                 */

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
                break;
        }
    }
}
