package com.helloapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.helloapp.R;
import com.helloapp.actions.ToastMsg;
import com.helloapp.model.ShoppingAdapter;

/**
 * Activity 3
 */

public class AcheterProduit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        String item = getIntent().getExtras().getString("item");
        TextView textView = (TextView)findViewById(R.id.a3t1);
        textView.setText(item);
    }

    public void onOui(View v){
        new ToastMsg(this,"Merci pour votre achat.");
        finish();
    }

    public void onNon(View v){
        new ToastMsg(this, "Produit pas acheté.");
        finish();

    }
}
