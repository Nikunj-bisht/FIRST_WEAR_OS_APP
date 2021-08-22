package com.animesafar.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Customview extends RecyclerView.ViewHolder {

    private TextView textView;

    public Customview(@NonNull View itemView) {
        super(itemView);
        textView =  itemView.findViewById(R.id.textView2);
    }


    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
