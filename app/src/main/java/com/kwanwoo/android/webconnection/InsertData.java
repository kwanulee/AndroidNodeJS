package com.kwanwoo.android.webconnection;

import android.app.Activity;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;



public class InsertData extends PostRequest {
    public InsertData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        EditText server = activity.findViewById(R.id.server);
        String serverURLStr = server.getText().toString();
        try {
            url = new URL(serverURLStr + "/insert");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
