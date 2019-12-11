package com.example.testapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp.R;
import com.example.testapp.model.Datum;

public class HzVIewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    OnItemClickListener onItemClickListener;
    TextView hz_textview;
    public HzVIewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        hz_textview = itemView.findViewById(R.id.textview_hz);

        itemView.setOnClickListener(this);
    }

    public void onBind(Datum datum){
        String text = datum.getData().getText();
        hz_textview.setText(text);
    }

    @Override
    public void onClick(View view) {

        onItemClickListener.onHzClick(hz_textview.getText().toString());
    }
}
