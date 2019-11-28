package com.example.api_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;

    private SimpleDraweeView simpleDraweeView_image;
    private TextView textView_name;
    private TextView textView_repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);

        simpleDraweeView_image = findViewById(R.id.SimpleDraweeView_Image);
        textView_name=findViewById(R.id.TextView_Name);
        textView_repos=findViewById(R.id.TextView_Repos);

        getRepos();

        textView_repos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ReposActivity.class);
                startActivity(intent);
            }
        });
    }


    public  void getRepos()
    {
        String url = "https://api.github.com/users/octocat";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            textView_name.setText(jsonObj.getString("login"));
                            simpleDraweeView_image.setImageURI(jsonObj.getString("avatar_url"));
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();

                                Log.d("ERROR ",e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}