package com.example.th05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TH05 extends AppCompatActivity {

    ArrayList<ItemThumbnail> listThumbnail;
    ThumbnailAdapter thumbnailAdapter;
    GridView gridView;
    DishAdapter dishAdapter;
    List<Dish> listDish;
    ItemThumbnail choseItemThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th05);

        initList();

        listDish = new ArrayList();
        EditText etName = (EditText) findViewById(R.id.et_name_b5);
        Button btAdd = (Button) findViewById(R.id.bt_addnewdish_b5);
        CheckBox cbPromotion = (CheckBox) findViewById(R.id.cb_promotion_b5);
        gridView = (GridView) findViewById(R.id.gv_listdish_b5);
        dishAdapter = new DishAdapter(this, R.layout.item_dish, listDish);
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail, listThumbnail);
        Spinner spinnerDish = (Spinner) findViewById(R.id.sn_thumbnail_b5);

        spinnerDish.setAdapter(thumbnailAdapter);
        gridView.setAdapter(dishAdapter);

        spinnerDish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choseItemThumbnail = (ItemThumbnail) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                boolean promotion = cbPromotion.isChecked();

                if (etName.getText().length() != 0) {
                    Dish dishItem = new Dish(name, choseItemThumbnail.getImg(), promotion);
                    listDish.add(dishItem);

                    dishAdapter.notifyDataSetChanged();

                    etName.getText().clear();
                    cbPromotion.setChecked(false);
                    spinnerDish.setSelection(0);
                    Toast.makeText(TH05.this, "Added successfully", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(TH05.this, "Insert name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void initList() {
        listThumbnail = new ArrayList();
        listThumbnail.add(new ItemThumbnail(Thumbnail.Thumbnail1.getName(),Thumbnail.Thumbnail1.getImg()));
        listThumbnail.add(new ItemThumbnail(Thumbnail.Thumbnail2.getName(),Thumbnail.Thumbnail2.getImg()));
        listThumbnail.add(new ItemThumbnail(Thumbnail.Thumbnail3.getName(),Thumbnail.Thumbnail3.getImg()));
        listThumbnail.add(new ItemThumbnail(Thumbnail.Thumbnail4.getName(),Thumbnail.Thumbnail4.getImg()));
    }

}