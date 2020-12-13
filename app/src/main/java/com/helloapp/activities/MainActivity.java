package com.helloapp.activities;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.helloapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Log.i("JAL","Une ligne de log");
        int i = android.R.drawable.alert_dark_frame;
        System.out.println(i);
        Resources res = getResources();

    }

    protected void onStart(Bundle SavedInstanceState){
        super.onStart();
    }


    public void onHeureDesCourses(View v){
        EditText edit = (EditText)findViewById(R.id.l1et1);
        String login = edit.getText().toString();

        TimePicker picker = (TimePicker)findViewById(R.id.simpleTimePicker);
        String hour = Integer.toString(picker.getHour());
        String minute = Integer.toString(picker.getMinute());

        String text = login + " doit faire les courses à " + hour + "h" + minute;

        TextView textView = (TextView)findViewById(R.id.l2t1);
        textView.setText(text);
    }

    public void onFaireLesCourses(){}

    public void onQuit(View v){
        finish();
        System.exit(0);
    }
}
