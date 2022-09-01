package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder> {

    private String[] data;
    public ProgrammingAdapter(String[] data) {
        this.data = data;
    }
    @Override
    public ProgrammingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammingAdapter.ProgrammingViewHolder holder, int position) {
        String title = data[position];
        holder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        ImageView imgLogo;
        TextView txtTitle;
        public ProgrammingViewHolder(View itemView) {
            super(itemView);
            imgLogo = (ImageView) itemView.findViewById(R.id.imgLogo);
            txtTitle = (TextView) itemView.findViewById(R.id.txtLabel);
        }
    }
}