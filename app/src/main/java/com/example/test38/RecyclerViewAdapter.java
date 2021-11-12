package com.example.test38;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.test38.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

 private Context mContext;
 private List<Chat> mData;
 RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Chat> mData) {
        this.mContext = mContext;
        this.mData = mData;


        //request option for glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view =inflater.inflate(R.layout.chat_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//binding the data
        holder.c_name.setText(mData.get(position).getName());
        holder.c_state.setText(mData.get(position).getState());

        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(holder.c_profile);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView c_name;
        TextView c_state;
        ImageView c_profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            c_name=itemView.findViewById(R.id.name);
            c_state=itemView.findViewById(R.id.state);
            c_profile=itemView.findViewById(R.id.profile_pic);

        }
    }
}
