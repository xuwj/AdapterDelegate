package com.xuwj.adapterdelagate;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


public interface AdapterDelegate<T> {


    int getItemViewType();


    boolean isForViewType(T items, int position);


    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);


    void onBindViewHolder(T items, int position, RecyclerView.ViewHolder holder);
}
