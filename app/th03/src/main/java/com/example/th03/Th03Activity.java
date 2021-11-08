package com.example.th03;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Th03Activity extends AppCompatActivity {

    ListView lvName;
    TextView tvSelection;
    EditText inputName;
    Button btnOK;
    ArrayList<Employee> employees;
    RadioGroup rgType;
    RadioButton rbFulltime;
    RadioButton rbParttime;
    EditText inputID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th03);

        lvName = (ListView) findViewById(R.id.listView);
        tvSelection = (TextView) findViewById(R.id.tvSelection);
        inputName = (EditText) findViewById(R.id.inputName);
        inputID = (EditText) findViewById(R.id.inputID);
        btnOK = (Button) findViewById(R.id.btnOK);
        rbFulltime = (RadioButton) findViewById(R.id.radioType);
        rbParttime = (RadioButton) findViewById(R.id.radioType2);
        rgType = (RadioGroup) findViewById(R.id.rgType);
        employees = new ArrayList<Employee>();


        ArrayAdapter adapter = new ArrayAdapter(Th03Activity.this, android.R.layout.simple_list_item_1, employees);
        lvName.setAdapter(adapter);

        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvSelection.setText("Position: " + (i+1) + "\nValue: " + employees.get(i));
                tvSelection.setTextColor(Color.BLUE);
            }
        });

        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvSelection.setText("Remove " + (i+1) + "\nValue: " + employees.get(i));
                tvSelection.setTextColor(Color.BLUE);
                adapter.remove(employees.get(i));
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
                addNewEmployee();
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
                inputName.getText().clear();
                inputID.getText().clear();
                rgType.clearCheck();
            }
        });
    }

    public void addNewEmployee() {
        //Lấy ra đúng id của Radio Button được checked
        Employee employee;
        int radId = rgType.getCheckedRadioButtonId();
        String id = inputID.getText().toString();
        String name = inputName.getText().toString();
        if (radId == R.id.radioType) {
            employee = new EmployeeFulltime();
        } else {
            employee = new EmployeeParttime();
        }
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        employees.add(employee);
        Log.v("hello", employee.getId());
    }
}
