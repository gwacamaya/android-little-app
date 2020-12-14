package com.helloapp.activities;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.helloapp.R;
import com.helloapp.model.ShoppingAdapter;

/**
 * Activity 2
 */

public class FaireCourses extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Bundle extras = getIntent().getExtras();
        // Set login to display
        TextView textView = (TextView)findViewById(R.id.a2t1);
        textView.setText("Hello " + extras.getString("login"));
        // Set list
        String[] user_shopping = extras.getStringArray("user_shopping");
        ShoppingAdapter shoppingAdapter = new ShoppingAdapter(this, user_shopping);
        ListView listView = (ListView)findViewById(R.id.a2lv1);
        listView.setAdapter(shoppingAdapter);
    }
}
