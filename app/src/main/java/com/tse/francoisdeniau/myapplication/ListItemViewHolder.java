package com.tse.francoisdeniau.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewName;
    private NameItemListener nameItemListener;

    private String name;

    public ListItemViewHolder(@NonNull View itemView, final NameItemListener nameItemListener){
        super(itemView);
        this.nameItemListener = nameItemListener;

        CardView cardView = itemView.findViewById(R.id.item_view_card_name);
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nameItemListener.clickOnItem(name);
            }
        });

        ImageView imageView = itemView.findViewById(R.id.imageView_name);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nameItemListener.clickOnCross(name);
            }
        });

        this.textViewName = itemView.findViewById(R.id.listitem_textview_name);
    }

    public void setContent(String name){
        this.name = name;
        textViewName.setText(name);
    }
}
