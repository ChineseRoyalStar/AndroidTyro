package com.example.armada.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
            "Pineapple", "Strawberry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
            "Pineapple", "Strawberry", "Cherry", "Mango" };

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.fruit_item, data);
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void initFruits() {

        for(int i = 0; i<2; i++) {

            Fruit apple = new Fruit("Apple", R.mipmap.apple);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana", R.mipmap.apple);
            fruitList.add(banana);

            Fruit orange = new Fruit("Oragne", R.mipmap.apple);
            fruitList.add(orange);

            Fruit watermelon = new Fruit("Watermelon", R.mipmap.apple);
            fruitList.add(watermelon);

            Fruit pear = new Fruit("Pear", R.mipmap.apple);
            fruitList.add(pear);

            Fruit grape = new Fruit("Grape", R.mipmap.apple);
            fruitList.add(grape);

            Fruit pineapple = new Fruit("Pineapple", R.mipmap.apple);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit("Strawberry",R.mipmap.apple);
            fruitList.add(strawberry);

            Fruit cherry = new Fruit("Cherry", R.mipmap.apple);
            fruitList.add(cherry);

            Fruit mango = new Fruit("Mango", R.mipmap.apple);
            fruitList.add(mango);
        }
    }
}
