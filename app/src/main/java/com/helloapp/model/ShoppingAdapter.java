package com.helloapp.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.helloapp.R;
import com.helloapp.actions.ToastMsg;
import com.helloapp.activities.AcheterProduit;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/**
 * Faire courses
 */

public class ShoppingAdapter extends ArrayAdapter<String> {
    public ShoppingAdapter(Context context, String[] shopping_list){
        super(context, 0, shopping_list);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String shopping_item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_2_shopping_list, parent, false);
        }
        // Lookup view for data population
        TextView tvShoppingItem = (TextView) convertView.findViewById(R.id.a2tvShoppingItem);
        //Populate the data into the template view using the data object
        tvShoppingItem.setText(shopping_item);
        tvShoppingItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acheter_produit(getContext(), shopping_item);
            }
        });

        return convertView;
    }

    public void acheter_produit(Context context, String item){
        Intent acheter = new Intent(context, AcheterProduit.class);
        acheter.putExtra("item", item);
        context.startActivity(acheter);

    }
}
