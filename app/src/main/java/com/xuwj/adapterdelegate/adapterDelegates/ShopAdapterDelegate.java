package com.xuwj.adapterdelegate.adapterDelegates;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xuwj.adapterdelagate.AbsAdapterDelegate;
import com.xuwj.adapterdelegate.R;
import com.xuwj.adapterdelegate.model.DisplayableItem;
import com.xuwj.adapterdelegate.model.ShopItem;
import com.xuwj.adapterdelegate.model.ShopTitleItem;

import java.util.List;

/**
 * Created by weijiang on 16/6/18.
 */

public class ShopAdapterDelegate extends AbsAdapterDelegate<List<DisplayableItem>> {

    private LayoutInflater inflater;
    private Activity mContext;

    public ShopAdapterDelegate(Activity activity, int viewType) {
        super(viewType);
        mContext = activity;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(List<DisplayableItem> items, int position) {
        return items.get(position) instanceof ShopItem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ShopViewHolder(inflater.inflate(R.layout.item_moudle_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(List<DisplayableItem> items, int position, RecyclerView.ViewHolder holder) {
        ShopViewHolder vh = (ShopViewHolder) holder;
        final ShopItem shopItem = (ShopItem) items.get(position);
        if (!TextUtils.isEmpty(shopItem.getName()))
            vh.mTvTitle.setText(shopItem.getName());
        vh.mTvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "content", Toast.LENGTH_LONG).show();
            }
        });
    }

    static class ShopViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;

        public ShopViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
