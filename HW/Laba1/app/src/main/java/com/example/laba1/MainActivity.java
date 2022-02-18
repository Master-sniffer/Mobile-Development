package com.example.laba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemLongClickListener {
    TextView textView;
    Button button, button2;
    ListView view;
    ArrayList<String> mNameList;
    ArrayAdapter mArrayAdapter;
    TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = findViewById(R.id.textView);
         button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        view = findViewById(R.id.viewwww);
         mNameList = new ArrayList<>();
         textInputEditText = findViewById(R.id.hint);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        view.setAdapter(mArrayAdapter);
        view.setOnItemClickListener(this);
//        mNameList.add("Andrew");
//        mNameList.add("Lara");
//        mNameList.add("klrar");

        button.setOnClickListener(okbutton);
        button2.setOnClickListener(okbutton);
        view.setOnItemLongClickListener(this::onItemLongClick);

    }

//        ListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//        @Override
//        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//            arrayList.remove(i);
//            adapter.notifyDataSetChanged();
//            return true;
//        }
//    });


    @Override
    public void onClick(View view) {
        textView.setText(textInputEditText.getText().toString()+ " is learning Android development!");
        mNameList.add(textInputEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    View.OnClickListener okbutton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button:
                    textView.setText(textInputEditText.getText().toString()+" well he didnt learn Android studio");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка Баттон", Toast.LENGTH_LONG).show();
                    if(!mNameList.contains(textInputEditText.getText().toString())) {
                        mNameList.add(textInputEditText.getText().toString());
                        Collections.sort(mNameList);
                        mArrayAdapter.notifyDataSetChanged();
                    }
                    break;
                case R.id.button2:
                    textView.setText(textInputEditText.getText().toString()+" well he decided to learn Android studio");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка Баттон*-1", Toast.LENGTH_LONG).show();
                    if(!mNameList.contains(textInputEditText.getText().toString())) {
                        mNameList.add(textInputEditText.getText().toString());
                        Collections.sort(mNameList);
                        mArrayAdapter.notifyDataSetChanged();
                    }
                    break;
            }

        }
    };

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("omg android", i + ": " + mNameList.get(i));
        textView.setText(mNameList.get(i).toString()
                + " is learning Android development!");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        mNameList.remove(i);
        mArrayAdapter.notifyDataSetChanged();
        return true;
    }
}