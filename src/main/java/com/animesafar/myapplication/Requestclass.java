package com.animesafar.myapplication;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Requestclass {

    public static void sendrequest(Context context , callback call){

        RequestQueue requestQueue = Volley.newRequestQueue(context);
String url = "https://safetyapiforw.herokuapp.com/api/jobssector";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray = response.getJSONArray("joby");
                    ArrayList<Data> a  = new ArrayList<>();
               for(int i=0;i<jsonArray.length();i++){
                     Data d = new Data(jsonArray.getJSONObject(i).getString("title"));
                   a.add(d);
               }
                    call.speak(a);

                }catch (Exception e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show();
            }
        });

requestQueue.add(jsonObjectRequest);
    }


}
