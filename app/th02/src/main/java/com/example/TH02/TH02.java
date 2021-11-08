package com.example.TH02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public class TH02 extends AppCompatActivity {

    ListView lvName;
    TextView tvSelection;
    EditText inputName;
    Button btnOK;
    ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th02);

        lvName = (ListView) findViewById(R.id.listView);
        tvSelection = (TextView) findViewById(R.id.tvSelection);
        inputName = (EditText) findViewById(R.id.inputName);
        btnOK = (Button) findViewById(R.id.btnOK);
        nameList = new ArrayList<>();

        nameList.add("Dinh");
        nameList.add("Dat");
        nameList.add("Vi");

        ArrayAdapter adapter = new ArrayAdapter(TH02.this, android.R.layout.simple_list_item_1, nameList);
        lvName.setAdapter(adapter);

        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvSelection.setText("Position: " + (i+1) + "\nValue: " + nameList.get(i));
                tvSelection.setTextColor(Color.BLUE);
            }
        });

        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvSelection.setText("Remove " + (i+1) + "\nValue: " + nameList.get(i));
                tvSelection.setTextColor(Color.BLUE);
                adapter.remove(nameList.get(i));
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        inputName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == keyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    btnOK.callOnClick();
                    return true;
                }
                return false;
            }
        });


        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String s = inputName.getText().toString();
                Log.v("name", s);
                if (s.length() > 0)
                {
                    nameList.add(inputName.getText().toString());
                    adapter.notifyDataSetChanged();
                    inputName.getText().clear();
                    Toast.makeText(getApplicationContext(), nameList.get(nameList.size()-1), Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Rỗng!", Toast.LENGTH_LONG).show();
            }
        });
    }
}