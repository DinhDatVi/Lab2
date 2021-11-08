package com.example.th05;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ThumbnailAdapter extends ArrayAdapter<ItemThumbnail> {

    private Activity context;
    public ThumbnailAdapter(Activity context, int layoutID,List<ItemThumbnail> thumbnailList) {
        super(context, layoutID, thumbnailList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_selected_thumbnail, null, false
            );
        }

        TextView itemSelectedName = convertView.findViewById(R.id.tv_name_selected_thumbnail_b5);

        ItemThumbnail itemThumbnail = getItem(position);

        if (itemThumbnail != null)
        {
            itemSelectedName.setText(itemThumbnail.getName());
            itemSelectedName.setGravity(Gravity.CENTER_VERTICAL);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_thumbnail, null, false
            );
        }

        TextView itemName = convertView.findViewById(R.id.tv_name_thumbnail_b5);
        ImageView itemImage = convertView.findViewById(R.id.iv_thumbnail_b5);

        ItemThumbnail itemThumbnail = getItem(position);

        if (itemThumbnail != null) {
            itemName.setText(itemThumbnail.getName());
            itemImage.setImageResource(itemThumbnail.getImg());
            itemName.setGravity(Gravity.CENTER_VERTICAL);
        }

        return convertView;
    }
}

