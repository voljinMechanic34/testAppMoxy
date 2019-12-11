package com.example.testapp.adapters;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.testapp.R;
import com.example.testapp.model.Datum;

public class PictureViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imageView_picture;
    OnItemClickListener onItemClickListener;
    String text;
    public PictureViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        imageView_picture = itemView.findViewById(R.id.imageview_picture);
        itemView.setOnClickListener(this);
    }
    public void onBind(Datum datum){
            String url = datum.getData().getUrl();

        Glide.with(itemView).load(url).into(imageView_picture);
        text = datum.getData().getText();
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onPictureClick(text);
    }
}
