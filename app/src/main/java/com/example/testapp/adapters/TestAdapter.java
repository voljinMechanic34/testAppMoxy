package com.example.testapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapp.R;
import com.example.testapp.model.Datum;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HZ_TYPE = 1;
    private static final int PICTURE_TYPE = 2;
    private static final int SELECTOR_TYPE = 3;
    private List<Datum> listDatum;
    OnItemClickListener onItemClickListener;

    public TestAdapter(List<Datum> listDatum, OnItemClickListener onItemClickListener) {
        this.listDatum = listDatum;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        switch (i){
            case HZ_TYPE:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hz_item_layout,viewGroup,false);
                return new HzVIewHolder(view,onItemClickListener);
            }
            case PICTURE_TYPE:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_item_layout,viewGroup,false);
                return new PictureViewHolder(view,onItemClickListener);
            }
            case SELECTOR_TYPE:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.selector_item_layout,viewGroup,false);
                return new SelectorViewHolder(view,onItemClickListener);
            }
            default:{
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hz_item_layout,viewGroup,false);
                return new HzVIewHolder(view,onItemClickListener);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType =getItemViewType(i);
            if (itemViewType == HZ_TYPE){
                ((HzVIewHolder)viewHolder).onBind(listDatum.get(i));
            }
            else if (itemViewType == PICTURE_TYPE){
                ((PictureViewHolder)viewHolder).onBind(listDatum.get(i));
            }
            else {
                ((SelectorViewHolder)viewHolder).onBind(listDatum.get(i));
            }
    }

    @Override
    public int getItemCount() {
        return listDatum.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(listDatum.get(position).getName().equals("hz")){
            return  HZ_TYPE;
        }
        else if (listDatum.get(position).getName().equals("selector")){
            return SELECTOR_TYPE;
        } else {
            return PICTURE_TYPE;
        }
    }
}
