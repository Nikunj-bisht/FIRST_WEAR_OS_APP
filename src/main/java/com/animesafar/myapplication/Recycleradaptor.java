package com.animesafar.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycleradaptor extends RecyclerView.Adapter<Customview> {

   private ArrayList<Data> arrayList;
   private Context context;
  private   LayoutInflater layoutInflater;

    Recycleradaptor(Context context , ArrayList<Data> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Customview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.customview , parent  , false);

        Customview customview = new Customview(view);

        return customview;
    }

    @Override
    public void onBindViewHolder(@NonNull Customview holder, int position) {

        holder.getTextView().setText(arrayList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
