package com.example.laba3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputEditText;
    Switch switch1,switch2,switch3;
    Button button;
    Integer min=0, max1=100,max2=1000,max3=10000;
    TextView textView;
    int random_int;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        button = findViewById(R.id.button);
        textView=findViewById(R.id.textView2);
        textInputEditText = findViewById(R.id.inp);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch2.setChecked(false);
                switch3.setChecked(false);
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch1.setChecked(false);
                switch3.setChecked(false);
            }
        });

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch2.setChecked(false);
                switch1.setChecked(false);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(textInputEditText.getText());
                if (switch1.isChecked()){
                    random_int  = new Random().nextInt((max1 - min) + 1) + min;
                    String numb=textInputEditText.getText().toString();
                    System.out.println(random_int+ "right answer");
                    if(numb.equals(Integer.toString(random_int))){
                        textView.setText("Молодец, ты угадал число !");
                    }else {
                        textView.setText("Мимо");
                    }
                    textInputEditText.setText("");
                }
                else if (switch2.isChecked()){
                    random_int  = new Random().nextInt((max2 - min) + 1) + min;
                    String numb=textInputEditText.getText().toString();
                    System.out.println(random_int+ "right answer");
                    if(numb.equals(Integer.toString(random_int))){
                        textView.setText("Молодец, ты угадал число !");
                    }else {
                        textView.setText("Мимо");
                    }
                    textInputEditText.setText("");

                }
                else if (switch3.isChecked()){
                    random_int  = new Random().nextInt((max3 - min) + 1) + min;
                    String numb=textInputEditText.getText().toString();
                    System.out.println(random_int+ "right answer");
                    if(numb.equals(Integer.toString(random_int))){
                        textView.setText("Молодец, ты угадал число !");
                    }else {
                        textView.setText("Мимо");
                    }
                    textInputEditText.setText("");

                }
                else{
                    textView.setText("Выбери уровень сложности");
                }

            }

        });
    }
}