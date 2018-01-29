package com.example.armada.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initFruits(); // 初始化水果数据
        initFruitsOfStagger();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

    /**
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    */

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

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

            Fruit orange = new Fruit("Orange", R.mipmap.apple);
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

    private void initFruitsOfStagger() {

        for(int i = 0; i<2; i++) {

            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.mipmap.apple);
            fruitList.add(apple);

            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.mipmap.apple);
            fruitList.add(banana);

            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.mipmap.apple);
            fruitList.add(orange);

            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.mipmap.apple);
            fruitList.add(watermelon);

            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.mipmap.apple);
            fruitList.add(pear);

            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.mipmap.apple);
            fruitList.add(grape);

            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.mipmap.apple);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"),R.mipmap.apple);
            fruitList.add(strawberry);

            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.mipmap.apple);
            fruitList.add(cherry);

            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.mipmap.apple);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {

        Random random = new Random();

        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length;i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
