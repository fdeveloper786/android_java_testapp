package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.zip.Inflater;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {
    private Context context;
    private User[] data;
    public ImageListAdapter(Context context, User[] data){
        this.context = context;
        this.data = data;
    }
    @Override

    public ImageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.image_list_layout,parent,false);
        return new ImageListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageListAdapter.ImageListViewHolder holder, int position) {
        User user = data[position];
        holder.txtUser.setText(user.getLogin());
        Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).into(holder.imgUser);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ImageListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgUser;
        TextView txtUser;

        public ImageListViewHolder( View itemView) {
            super(itemView);
            imgUser = (ImageView) itemView.findViewById(R.id.imgUser);
            txtUser = (TextView) itemView.findViewById(R.id.txtUser);
        }
    }
}
