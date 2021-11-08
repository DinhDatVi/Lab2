package com.example.th04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class TH04 extends AppCompatActivity {

    EditText editId;
    EditText editName;
    Button btnNhap;
    CheckBox cbManger;
    ListView lvNhanvien;
    ArrayList<Employee> arrEmployee = new ArrayList();
    EmployeeAdapter adapter = null;
    Employee employee = null;

    public TH04() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_th04);
        this.editId = (EditText)this.findViewById(R.id.inputID);
        this.editName = (EditText)this.findViewById(R.id.inputName);
        this.btnNhap = (Button)this.findViewById(R.id.btnOK);
        this.cbManger = (CheckBox)this.findViewById(R.id.cbManger);
        this.lvNhanvien = (ListView)this.findViewById(R.id.listView);
        this.adapter = new EmployeeAdapter(this, 17367043, this.arrEmployee);
        this.lvNhanvien.setAdapter(this.adapter);
        this.btnNhap.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                TH04.this.processNhap();
            }
        });
    }

    public void processNhap() {
        boolean isManager = this.cbManger.isChecked();
        String id = this.editId.getText() + "";
        String name = this.editName.getText() + "";
        this.employee = new Employee();
        this.employee.setManager(isManager);
        this.employee.setId(id);
        this.employee.setName(name);
        this.arrEmployee.add(this.employee);
        this.adapter.notifyDataSetChanged();
        editId.getText().clear();
        editName.getText().clear();
        cbManger.setChecked(false);
    }
}