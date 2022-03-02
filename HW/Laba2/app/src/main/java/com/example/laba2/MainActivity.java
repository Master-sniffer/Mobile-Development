package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    private long inc=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("abobus");
                inc++;
                textView.setText("Поздравляю, ты уже нажал "+inc);
            }
        });
    }

    public void sendMessage(View view) {
        if(inc==0){
            textView.setText("БОЛЬШЕ НЕЛЬЗЯ ОПУСКАТЬСЯ");
        } else{
            inc--;
            textView.setText("Поздравляю, ты уже нажал "+inc);

        }
    }

    public void reset(View view) {
        inc=0;
        textView.setText("Поздравляю, ты на дне, у тебя 0 кликов");
    }

}