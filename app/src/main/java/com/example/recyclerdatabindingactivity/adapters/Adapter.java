package com.example.recyclerdatabindingactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerdatabindingactivity.recycerview.items.UniverseItem;
import com.example.recyclerdatabindingactivity.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<UniverseItem> items;

    public Adapter(Context context, ArrayList<UniverseItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView= inflater.inflate(R.layout.recycler_item, parent, false);
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        UniverseItem item= items.get(position);
        //vh.photo.setImageURI(item.photoUrl);
        Glide.with(context).load(item.photoUrl).into(vh.photo);  // String Uri item
        vh.title.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class VH extends RecyclerView.ViewHolder{
        CircleImageView photo;
        TextView title;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.photo= itemView.findViewById(R.id.circle_photo);
            this.title= itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, items.get(getLayoutPosition())+" 번째", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}


