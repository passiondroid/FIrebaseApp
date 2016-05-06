package com.example.akhan.firebaseapp.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.akhan.firebaseapp.R;
import com.example.akhan.firebaseapp.interfaces.OnItemClickListener;
import com.example.akhan.firebaseapp.model.Category;

import java.util.List;

/**
 * Created by akhan on 5/3/2016.
 */
public class ChannelRecyclerAdapter extends RecyclerView.Adapter<ChannelRecyclerAdapter.ViewHolder> {

    private List<Category> categoryList;
    private Context context;
    private static OnItemClickListener listener;

    public ChannelRecyclerAdapter(Context context, List<Category> categoryList) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.layout_category_item, parent, false);
        /*int height = parent.getMeasuredHeight() / 2;
        contactView.setMinimumHeight(height);*/

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.categoryTV.setText(categoryList.get(position).getName());

        Glide.with(context)
                .load(categoryList.get(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .crossFade()
                .into(holder.categoryIV);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView categoryTV;
        public ImageView categoryIV;

        public ViewHolder(final View itemView) {
            super(itemView);
            categoryTV = (TextView)itemView.findViewById(R.id.categoryTV);
            categoryIV = (ImageView)itemView.findViewById(R.id.categoryIV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });

        }
    }

    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
