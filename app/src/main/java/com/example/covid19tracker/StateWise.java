package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19tracker.api.statedata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StateWise extends AppCompatActivity {

    
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    stateAdapter stateAdap;
      List<statedata> movie;
 //   statedata statelist;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_wise);
        recyclerView=findViewById(R.id.staterecy);


        movie=new ArrayList<>();
        stateAdap=new stateAdapter(getApplicationContext(),movie);

        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        recyclerView.setAdapter(stateAdap);




        getStateInfo();
        
        
        
        
    }

    private void getStateInfo() {
        String url = "https://api.rootnet.in/covid19-in/stats/latest.json";
        RequestQueue queue = Volley.newRequestQueue(StateWise.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {



                    @Override
                    public void onResponse(JSONObject response) {

                        try {



                            JSONObject dataobj=response.getJSONObject("data");
                            Log.i("is volley", dataobj.toString());

                            JSONArray regArray=dataobj.getJSONArray("regional");
                             for(int i =0 ;i<regArray.length();i++){
                                 JSONObject regionalobj=regArray.getJSONObject(i);
                                 String statename=regionalobj.getString("loc");
                                 String cases=regionalobj.getString("totalConfirmed");
                                 String Death=regionalobj.getString("deaths");

                                 statedata data=new statedata();
                                 data.setDeaths(Death);
                                 data.setLoc(statename);
                                 data.setTotalConfirmed(cases);

                                 movie.add(data);






                           
                             }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    stateAdap.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.e("Volley",error.toString());


                    }
                });

        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }}