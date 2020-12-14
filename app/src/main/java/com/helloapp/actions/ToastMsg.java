package com.helloapp.actions;

import android.content.Context;
import android.widget.Toast;

public class ToastMsg {
    public ToastMsg(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}
