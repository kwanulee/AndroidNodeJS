package com.kwanwoo.android.webconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "AndroidNodeJS";
    final static String defaultUrl = "http://172.30.1.40:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText server = (EditText) findViewById(R.id.server);
        server.setText(defaultUrl);

        Button insertBtn = (Button) findViewById(R.id.insertBtn);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit_title = (EditText) findViewById(R.id.title);
                EditText edit_content = (EditText) findViewById(R.id.content);
                EditText edit_author = (EditText) findViewById(R.id.author);

                JSONObject postDataParam = new JSONObject();
                try {
                    postDataParam.put("title", edit_title.getText().toString());
                    postDataParam.put("content", edit_content.getText().toString());
                    postDataParam.put("author", edit_author.getText().toString());
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new InsertData(MainActivity.this).execute(postDataParam);
                new GetData(MainActivity.this).execute();
            }
        });

        Button getBtn = (Button) findViewById(R.id.getBtn);
        getBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new GetData(MainActivity.this).execute();

            }
        });

        ListView txtList = (ListView) findViewById(R.id.txtList);
        txtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                JSONObject postDataParam = new JSONObject();
                try {
                    postDataParam.put("id", ((Book)adapter.getItem(i)).id);
                } catch (JSONException e) {
                    Log.e(TAG, "JSONEXception");
                }
                new DeleteData(MainActivity.this).execute(postDataParam);
                new GetData(MainActivity.this).execute();
            }
        });
    }
}


