package com.example.listviewsearch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView lv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.text_search);
        lv = (ListView) findViewById(R.id.list_contact);
        String[] name = {"Apple", "Appy", "Banana", "Cherry", "Date", "Grape" , "Kiwi" , "Mango" , "Pear"};
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                name
        );
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
                MainActivity.this.adapter.getFilter().filter(cs);
                if(et.getText().toString().trim().length() != 0) {
                    lv.setAdapter(adapter);
                }else {
                    lv.setAdapter(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "you choosed " + i,
                        Toast.LENGTH_LONG
                ).show();
            }
        });

    }
}