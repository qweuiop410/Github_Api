package com.example.api_test;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.MyViewHolder>{
    private List<ReposData> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_title;
        public TextView textView_content;
        public TextView textView_id;

        public MyViewHolder(final View v) {
            super(v);
            textView_title = v.findViewById(R.id.TextView_ReposDataTitle);
            textView_content = v.findViewById(R.id.TextView_ReposDataContent);
            textView_id= v.findViewById(R.id.TextView_ReposDataID);
        }
    }

    public ReposAdapter(List<ReposData> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ReposAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_repos, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView_title.setText( mDataset.get(position).getTitle());
        holder.textView_content.setText(mDataset.get(position).getContent());
        holder.textView_id.setText(mDataset.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return mDataset ==null ? 0 : mDataset.size();
    }
}