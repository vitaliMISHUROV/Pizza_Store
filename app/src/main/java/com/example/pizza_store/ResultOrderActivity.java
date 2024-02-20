package com.example.pizza_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ResultOrderActivity extends AppCompatActivity {
    private TextView  textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_order);

        textView = findViewById(R.id.txView);
        Intent intent = getIntent();
        Order order = (Order)  intent.getSerializableExtra(MainActivity.KEYORDER);
        textView.setText(order.toString());
    }
}