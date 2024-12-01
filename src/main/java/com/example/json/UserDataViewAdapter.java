package com.example.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserDataViewAdapter extends RecyclerView.Adapter<UserDataViewAdapter.RecyclerViewHolder> {


    private ArrayList<UserData> userDataArrayList;
    private Context mcontext;

    public UserDataViewAdapter (ArrayList<UserData> userDataArrayList, Context mcontext){
        this.userDataArrayList = userDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public  RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ){
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout, parent, false);
        return new RecyclerViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder,int position){
       UserData modal = userDataArrayList.get(position);
        holder.title.setText(modal.getTitle());
        holder.description.setText(modal.getDescription());
        holder.date.setText(modal.getDate());
        holder.content.setText(modal.getContent());
        holder.author.setText(modal.getAuthor());


    }
    public int getItemCount(){
        return userDataArrayList.size();

    }
    public class RecyclerViewHolder extends  RecyclerView.ViewHolder{
        private TextView title,description,date,content,author;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);

            title  = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);


        }

    }



}
