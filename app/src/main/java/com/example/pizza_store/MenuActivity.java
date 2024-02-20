package com.example.pizza_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView takeinfo;
    private Order order;
    private CheckBox firstchecbox;
    private CheckBox secondchecbox;
    private CheckBox thirthchecbox;

    private Button  btnnextActivity;
private RadioGroup groupRadiogroup;
private RadioGroup groupRad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        takeinfo = findViewById(R.id.evMenu);

        btnnextActivity = findViewById(R.id.btnNextResultActivity);
        firstchecbox = findViewById(R.id.firstChecbox);
        secondchecbox = findViewById(R.id.secondChecbox);
        thirthchecbox = findViewById(R.id.thirdChecbox);
        groupRadiogroup = findViewById(R.id.groupRadiogroup);
        groupRad = findViewById(R.id.rbnew);

        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra(MainActivity.KEYORDER);
        takeinfo.setText("Name: " + order.getName() + ", Numbers: " + order.getNumbers());


        btnnextActivity.setOnClickListener(this::send);
        groupRadiogroup.setOnCheckedChangeListener(this::AddSize);
        groupRad.setOnCheckedChangeListener(this::AddElseSomething);
    }

    private void AddElseSomething(RadioGroup radioGroup, int id) {
        String dishes = null;
        if (id ==R.id.radioButton7){
            dishes = "Paper";
        } else if (id ==R.id.radioButton8) {
            dishes = "Onion";

        } else if (id == R.id.radioButton9) {
            dishes = "Cherry";

        }
        order.setDishes(dishes);
        Toast.makeText(this, dishes, Toast.LENGTH_SHORT).show();

    }


    private void AddSize(RadioGroup radioGroup, int id) {
        String size = null;
        if (id == R.id.firstRadioButton) {
            size = "little";
        } else if (id == R.id.secondRadiobatton) {
            size = "Middle";
        } else if (id == R.id.thirthRadiobatton) {
            size = "BIG";
        }
        order.setSize(size);
        Toast.makeText(this, size, Toast.LENGTH_SHORT).show();

    }

    private void send(View view) {

        String result = "";
        order.getIngredients().clear();
        if (firstchecbox.isChecked()) {
            result += "4Chesses";
            order.getIngredients().add("4chesse");
        }  if (secondchecbox.isChecked()) {
            result += "4Meet";
            order.getIngredients().add("4Meet");

        } if (thirthchecbox.isChecked()) {
            result += " Margarita";
            order.getIngredients().add("Margarita");
        }
        takeinfo.setText(result);

        Toast.makeText(this, order.toString(), Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(this, ResultOrderActivity.class);
        intent.putExtra(MainActivity.KEYORDER, order);
        startActivity(intent);
    }


}