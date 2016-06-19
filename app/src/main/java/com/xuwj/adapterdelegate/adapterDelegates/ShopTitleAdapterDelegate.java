package com.xuwj.adapterdelegate.adapterDelegates;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.xuwj.adapterdelagate.AbsAdapterDelegate;
import com.xuwj.adapterdelegate.R;
import com.xuwj.adapterdelegate.model.DisplayableItem;
import com.xuwj.adapterdelegate.model.ShopTitleItem;

import java.util.List;

/**
 * Created by weijiang on 16/6/19.
 */

public class ShopTitleAdapterDelegate extends AbsAdapterDelegate<List<DisplayableItem>> {

    private LayoutInflater inflater;
    private Activity mContext;

    public ShopTitleAdapterDelegate(Activity activity, int viewType) {
        super(viewType);
        mContext = activity;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(List<DisplayableItem> items, int position) {
        return items.get(position) instanceof ShopTitleItem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ShopTitleViewHolder(inflater.inflate(R.layout.item_moudle_shop_title, parent, false));
    }

    @Override
    public void onBindViewHolder(List<DisplayableItem> items, int position, RecyclerView.ViewHolder holder) {
        ShopTitleViewHolder vh = (ShopTitleViewHolder) holder;
        final ShopTitleItem shopTitleItem = (ShopTitleItem) items.get(position);
        if (!TextUtils.isEmpty(shopTitleItem.getName()))
            vh.mTvTitle.setText(shopTitleItem.getName());
        vh.mTvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "title", Toast.LENGTH_LONG).show();
            }
        });
    }

    static class ShopTitleViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;

        public ShopTitleViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}