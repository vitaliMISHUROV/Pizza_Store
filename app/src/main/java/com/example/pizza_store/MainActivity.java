package com.example.pizza_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
//git
public class MainActivity extends AppCompatActivity {

    public static final String KEYORDER = "keyorder";
    private Button btSave;
    private TextInputEditText inputName;
    private EditText inpNumber;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.textInputName);
        inpNumber = findViewById(R.id.etNumber);
        btSave = findViewById(R.id.btnSave);

        inputName.addTextChangedListener(textWatcher);
        inpNumber.addTextChangedListener(textWatcher);

        order = new Order();

        btSave.setOnClickListener(v -> {
            if (isFieldsNotEmpty()) {
                Intent intent = new Intent(this, MenuActivity.class);
                String message = inputName.getText().toString();
                String numberText = inpNumber.getText().toString();
                int numbers = Integer.parseInt(numberText);

                order.setName(message);
                order.setNumbers(numbers);
                intent.putExtra(KEYORDER, order);
                startActivity(intent);
            }
        });
    }


    private  TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            btSave.setEnabled(isFieldsNotEmpty());
        }
    };

    private boolean isFieldsNotEmpty() {
        return inputName.getText().toString().trim().length() != 0
                && inpNumber.getText().toString().trim().length() != 0;
    }
}