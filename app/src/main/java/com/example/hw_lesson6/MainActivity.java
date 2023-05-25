package com.example.hw_lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl_registration;
    Button btn_entrance;
    EditText email, pass;
    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome = findViewById(R.id.welcome);
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        rl_registration = findViewById(R.id.rl_entrance);
        btn_entrance = findViewById(R.id.btn_entrance);



        email.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.length() > 0 ){
                    btn_entrance.setBackgroundColor(getResources().getColor(R.color.orange));
                }else {
                    // Измените цвет кнопки на исходный цвет
                    btn_entrance.setBackgroundColor(Color.GRAY);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn_entrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("Admin") && pass.getText().toString().equals("Admin")){
                    rl_registration.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно вошли", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Не правильно ввели пароль или почту", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}