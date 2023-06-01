package com.example.firebaserecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myAdapter extends FirebaseRecyclerAdapter<model,myAdapter.myViewHolder> {
    public myAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        Glide.with(holder.image.getContext()).load(model.getImg()).into(holder.image);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name,email;
        public myViewHolder(@NonNull View itemView) {
         super(itemView);
         image = itemView.findViewById(R.id.img_id);
         name = itemView.findViewById(R.id.name_id);
         email = itemView.findViewById(R.id.email_id);
        }
    }

}
