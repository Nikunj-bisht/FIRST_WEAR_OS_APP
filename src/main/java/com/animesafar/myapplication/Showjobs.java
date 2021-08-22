package com.animesafar.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class Showjobs extends Activity {

    private  ArrayList<Data> arrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showjobs);

              arrayList  = (ArrayList)getIntent().getSerializableExtra("<?>");
recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(new Recycleradaptor(this , arrayList));
         recyclerView.setLayoutManager(linearLayoutManager);

    }
}