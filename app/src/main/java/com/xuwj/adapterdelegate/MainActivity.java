package com.xuwj.adapterdelegate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.xuwj.adapterdelegate.adapter.ShopAdapter;
import com.xuwj.adapterdelegate.model.DisplayableItem;
import com.xuwj.adapterdelegate.model.ShopItem;
import com.xuwj.adapterdelegate.model.ShopTitleItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        ShopAdapter adapter = new ShopAdapter(this);
        rv.setAdapter(adapter);
        adapter.addAll(getItems());

    }

    private List<DisplayableItem> getItems() {
        List<DisplayableItem> shopItems = new ArrayList<>();

        shopItems.add(new ShopTitleItem("猜你喜欢"));
        shopItems.add(new ShopItem("红豆"));
        shopItems.add(new ShopItem("红豆"));
        shopItems.add(new ShopItem("红豆"));
        shopItems.add(new ShopItem("红豆"));

        shopItems.add(new ShopTitleItem("你画我猜"));
        shopItems.add(new ShopItem("蓝颜"));
        shopItems.add(new ShopItem("红颜"));
        shopItems.add(new ShopItem("绿颜"));
        shopItems.add(new ShopItem("紫嫣"));
        shopItems.add(new ShopItem("橙颜"));
        shopItems.add(new ShopItem("黄颜"));

        shopItems.add(new ShopTitleItem("神来之笔"));
        shopItems.add(new ShopItem("画龙点睛"));
        shopItems.add(new ShopItem("画蛇添足"));
        shopItems.add(new ShopItem("画画画"));

        shopItems.add(new ShopTitleItem("哪里走"));
        shopItems.add(new ShopItem("去哪里"));

        return shopItems;
    }
}
