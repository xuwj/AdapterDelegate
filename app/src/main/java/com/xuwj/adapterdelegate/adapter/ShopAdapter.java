package com.xuwj.adapterdelegate.adapter;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.xuwj.adapterdelagate.AdapterDelegatesManager;
import com.xuwj.adapterdelegate.adapterDelegates.ShopAdapterDelegate;
import com.xuwj.adapterdelegate.adapterDelegates.ShopTitleAdapterDelegate;
import com.xuwj.adapterdelegate.model.DisplayableItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品适配器
 * Created by weijiang on 16/6/19.
 */

public class ShopAdapter extends RecyclerView.Adapter {

    private AdapterDelegatesManager<List<DisplayableItem>> delegatesManager;
    private List<DisplayableItem> items;

    public ShopAdapter(Activity activity) {
        this.items = new ArrayList<>();

        // Delegates
        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new ShopAdapterDelegate(activity, 0));
        delegatesManager.addDelegate(new ShopTitleAdapterDelegate(activity, 1));
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == 1
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    public void addAll(List<DisplayableItem> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        this.items.remove(position);
        notifyDataSetChanged();
    }

    public void removeAll() {
        this.items.clear();
        notifyDataSetChanged();
    }

    public void add(DisplayableItem displayableItem) {
        this.items.add(displayableItem);
        notifyDataSetChanged();
    }

    public void add(int position, DisplayableItem displayableItem) {
        this.items.add(position, displayableItem);
        notifyDataSetChanged();
    }
}
