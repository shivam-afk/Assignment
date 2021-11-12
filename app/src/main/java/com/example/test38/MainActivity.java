package com.example.test38;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//calling the api
    private final String JSON_URL = "https://randomuser.me/api/?results=30";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Chat> lstChat;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstChat = new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
//requesting objects from api
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                JSONObject jsonObject = null;

                for (int i =0;i<response.length();i++)
                {
                    try{
                        jsonObject=response.getJSONObject(i);
                        Chat chat = new Chat();
                        chat.setName(jsonObject.getString("name"));
                        chat.setState(jsonObject.getString("location"));
                        chat.setImage(jsonObject.getString("thumbnail"));
                        lstChat.add(chat);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
                setuprecyclerview(lstChat);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);


    }

    private void setuprecyclerview(List<Chat> lstChat) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstChat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);

    }
}