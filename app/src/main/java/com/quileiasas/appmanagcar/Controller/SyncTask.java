package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.quileiasas.appmanagcar.DB.historialDAO;
import com.quileiasas.appmanagcar.DB.personaDAO;
import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.Services.VolleyS;
import com.quileiasas.appmanagcar.Services.jsonHelper;


import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;



public class SyncTask
{
    final Handler handler = new Handler();
    Timer timer = new Timer();
    int time;


    public SyncTask(final Activity activity, int time)
    {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {



                            VolleyS volleyS= new VolleyS(activity);
                            // using online service seee mockable.io
                            String url = "http://demo1703307.mockable.io";

                            //data
                            jsonHelper helper = new jsonHelper() ;
                            vehiculoDAO vehiculoDAO = new vehiculoDAO(activity) ;
                            historialDAO historialDAO = new historialDAO(activity,-1) ;
                            personaDAO personaDAO = new personaDAO(activity) ;

                            //System.out.println(helper.getResults(vehiculoDAO.listarData()));
                            //System.out.println(helper.getResults(personaDAO.listarData()));
                            //System.out.println(helper.getResults(historialDAO.listarData()));

                            JSONObject json = new JSONObject();
                            // populate the array
                            json.put("vehiculos",helper.getResults(vehiculoDAO.listarData()));
                            json.put("personas",helper.getResults(personaDAO.listarData()));
                            json.put("historial",helper.getResults(historialDAO.listarData()));


                            JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.PUT, url, json,
                                    new Response.Listener<JSONObject>()
                                   {

                                    @Override
                                        public void onResponse(JSONObject response) {
                                            // response
                                            Log.d("Response", response.toString());
                                        }
                                    },
                                    new Response.ErrorListener()
                                    {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            // error
                                            Log.d("Error.Response", error.toString());
                                        }
                                    }
                            );

                            volleyS.addToQueue(putRequest);
                            Toast.makeText(activity, "Generando sincro bro...", Toast.LENGTH_SHORT).show();
                        } catch (Exception e)
                        {
                            Log.e("error", e.getMessage());
                        }
                    }
                });
            }
        };

        timer.schedule(task, 0, time);
    }


}
