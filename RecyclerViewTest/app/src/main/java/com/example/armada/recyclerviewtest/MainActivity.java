package com.example.armada.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits(); // 初始化水果数据

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
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
