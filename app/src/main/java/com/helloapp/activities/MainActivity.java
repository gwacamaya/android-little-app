package com.helloapp.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.helloapp.R;
import com.helloapp.actions.ToastMsg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private final JSONObject SHOPPING = new JSONObject("{\"jhon\":[\"papas\",\"lechuga\",\"zanahoria\"]," +
                                                            "\"neo\":[\"pommes\",\"cafe\"]}");

    public MainActivity() throws JSONException {
    }

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

    public void onQuit(View v){
        finish();
        System.exit(0);
    }

    public void onFaireLesCourses(View v){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url =( (TextView)findViewById(R.id.a1l3et1)).getText().toString();


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            handleCourses(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
                try {
                    new ToastMsg(getApplicationContext(), "Server not found or broken. Using default examples.");
                    handleCourses(SHOPPING.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    public void handleCourses(String response) throws JSONException {

        JSONObject shopping = new JSONObject(response);

        String login_typed = ((EditText)findViewById(R.id.l1et1)).getText().toString();
        Iterator logins = shopping.keys();
        //Check in all the logins if the one typed by the users exits
        boolean loginExists = false;
        while(logins.hasNext()){
            String login = logins.next().toString();
            if (login.equals(login_typed)){
                loginExists = true;
                break;
            }
        }

        if(loginExists){
            Intent faireCourses = new Intent(this, FaireCourses.class);
            JSONArray shopping_list = (JSONArray)shopping.get(login_typed);
            String[] list = new String[shopping_list.length()];
            for(int i=0; i<list.length; i++){
                list[i] = shopping_list.getString(i);
            }

            faireCourses.putExtra("login",login_typed);
            faireCourses.putExtra("user_shopping", list);
            startActivity(faireCourses);
        }else{
            new ToastMsg(this,"Login not found");
        }
    }
}
