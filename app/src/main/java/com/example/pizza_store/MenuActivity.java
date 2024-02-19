package com.example.pizza_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

//    private TextView takeinfo;
    private  Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


//        takeinfo = findViewById(R.id.evMenu);


//
//        Intent intent = getIntent();
//        order = (Order) intent.getSerializableExtra(MainActivity.KEYORDER);
//        takeinfo.setText("Name: " + order.getName() + ", Numbers: " + order.getNumbers());




    }
}