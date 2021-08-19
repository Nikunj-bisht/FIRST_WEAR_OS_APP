package com.animesafar.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.animesafar.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTextView;
    private ActivityMainBinding binding;
private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button){

            Intent intent = new Intent(this,MyWatchFace.class);
            startActivity(intent);

        }

    }
}