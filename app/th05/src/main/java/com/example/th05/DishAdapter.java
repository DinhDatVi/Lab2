package com.example.th05;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DishAdapter extends BaseAdapter {

    private List<Dish> listDish;
    private int idLayout;
    private Context context;

    public DishAdapter(Context context, int idLayout, List<Dish> listDish) {
        this.idLayout = idLayout;
        this.listDish = listDish;
        this.context = context;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount(){
        if (listDish.size() != 0 && !listDish.isEmpty()) {
            return listDish.size();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        Dish dish = listDish.get(position);

        TextView tvNameDish = convertView.findViewById(R.id.tv_dish_b5);
        ImageView ivImageDish = convertView.findViewById(R.id.iv_dish_b5);
        ImageView ivPromotionDish = convertView.findViewById(R.id.iv_promotion_b5);

        if (listDish != null && !listDish.isEmpty()) {
            if (dish.getName() != null) {
                tvNameDish.setText(dish.getName());
                tvNameDish.setSelected(true);
            } else {
                tvNameDish.setText("");
            }

            if (dish.getPic() != 0) {
                ivImageDish.setBackground(context.getResources().getDrawable(dish.getPic()));
            }

            if (dish.isPromotion()) {
                ivPromotionDish.setVisibility(View.VISIBLE);
            } else {
                ivPromotionDish.setVisibility(View.GONE);
            }
        }
        return convertView;
    }
}
