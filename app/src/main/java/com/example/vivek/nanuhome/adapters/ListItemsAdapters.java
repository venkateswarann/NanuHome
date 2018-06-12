package com.example.vivek.nanuhome.adapters;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivek.nanuhome.R;
import com.example.vivek.nanuhome.pojo.HomeItems;

import java.util.List;


public class ListItemsAdapters extends RecyclerView.Adapter<ListItemsAdapters.ViewHoler> {

     private Context context;

    private List<HomeItems> items;


    public ListItemsAdapters(List<HomeItems> items, Context context) {
        this.items = items;
        this.context = context;

    }



    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.itemName.setText(items.get(position).getItemName());
    }

    @Override

    public int getItemCount() {

        return items.size();

    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        TextView itemName;
        public ViewHoler(View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.itemName);
        }
    }


}