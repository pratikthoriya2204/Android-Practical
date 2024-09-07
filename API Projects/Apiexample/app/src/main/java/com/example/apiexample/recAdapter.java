package com.example.apiexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recAdapter extends RecyclerView.Adapter<recAdapter.CustomViewHolder>{

    private List<postPojo> dataList;
    private Context context;

    public recAdapter(List<postPojo> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView title,posts;
        public CustomViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            posts = itemView.findViewById(R.id.posts);

        }
    }
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.api_data_design,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CustomViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.posts.setText(dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
