package com.example.api_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReposActivity extends AppCompatActivity {

    private SimpleDraweeView simpleDraweeView_reposImage;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        queue = Volley.newRequestQueue(this);

        simpleDraweeView_reposImage = findViewById(R.id.SimpleDraweeView_reposImage);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getRepos();
    }

    public  void getRepos()
    {
        String url = "https://api.github.com/users/octocat/repos";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            final List<ReposData> repos = new ArrayList<ReposData>();
                            final JSONArray arrayArticles =new JSONArray(response);

                            simpleDraweeView_reposImage.setImageURI(arrayArticles.getJSONObject(0).getJSONObject("owner").getString("avatar_url"));

                            for(int i = 0, j= arrayArticles.length() ; i < j ; i++)
                            {
                                JSONObject obj =  arrayArticles.getJSONObject(i);

                                ReposData reposData = new ReposData();
                                reposData.setTitle( obj.getString("name"));
                                reposData.setId( obj.getString("stargazers_count"));
                                reposData.setContent( obj.getString("description"));
                                repos.add(reposData);

                                // stargazers_count 정렬
                                Collections.sort(repos, new Comparator<ReposData>()
                                {
                                    @Override
                                    public int compare(ReposData b1, ReposData b2)
                                    {
                                        int num1 = Integer.parseInt(b1.getId());
                                        int num2 = Integer.parseInt(b2.getId());

                                        if(num1 > num2)
                                            return -1;
                                        else if (num1 < num2)
                                            return 1;
                                        else
                                            return 0;
                                    }
                                });
                            }

                            mAdapter = new ReposAdapter(repos);
                            recyclerView.setAdapter(mAdapter);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                            Log.d("     News",e.getMessage());
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