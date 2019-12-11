package com.example.testapp.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.testapp.R;
import com.example.testapp.model.Datum;


public class SelectorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView textSelector;
    OnItemClickListener onItemClickListener;
    public SelectorViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        textSelector = itemView.findViewById(R.id.textview_selector);
        itemView.setOnClickListener(this);
    }

    public void onBind(Datum datum){
        String text = datum.getVariantText().getText();
        if (datum.getVariantText().getId() == datum.getVariantText().getSelectedId()){
            textSelector.setBackgroundColor(Color.GRAY);
        }
        textSelector.setText(text);
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onSelectorClick(textSelector.getText().toString());
    }
}
