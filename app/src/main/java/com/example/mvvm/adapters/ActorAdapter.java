package com.example.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm.R;
import com.example.mvvm.model.Actors;

import java.util.List;
import java.util.zip.Inflater;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder> {

    private Context context;
    private List<Actors>  actorsList;


    public ActorAdapter(Context context, List<Actors> actorsList) {
        this.context = context;
        this.actorsList = actorsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the singleItem View
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActorAdapter.ViewHolder holder, int position) {
        //holder contains the referred Views and now we have to set the data
        String name=actorsList.get(position).getName();
        int age=actorsList.get(position).getAge();
        holder.nameView.setText(name);
        holder.ageView.setText(age);

        Glide.with(context).load(actorsList.get(position).getImageUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return actorsList.size();
    }

    //for setting the ActorsList so that the data can be comverted into the Views
    public void setActorsList(List<Actors> actorsList){
        this.actorsList=actorsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView,ageView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            //itemView contains the inflated View
            super(itemView);
            //referring the Views
            nameView=itemView.findViewById(R.id.nameActor);
            ageView=itemView.findViewById(R.id.ageActor);
            imageView=itemView.findViewById(R.id.imageActor);
        }
    }
}
