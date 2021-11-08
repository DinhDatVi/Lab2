package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvName;
    TextView tvName;
    ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvName = (ListView) findViewById(R.id.listView);
        tvName = (TextView) findViewById(R.id.textView);
        nameList = new ArrayList<>();

        nameList.add("Dinh");
        nameList.add("Dat");
        nameList.add("Vi");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, nameList);
        lvName.setAdapter(adapter);

        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvName.setText("Position: " + (i+1) + "\nValue: " + nameList.get(i));
                tvName.setTextColor(Color.BLUE);
            }
        });

        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvName.setText("Remove " + (i+1) + "\nValue: " + nameList.get(i));
                tvName.setTextColor(Color.BLUE);
                adapter.remove(nameList.get(i));
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}