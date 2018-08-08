package com.quileiasas.appmanagcar.Services;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {
    private static VolleyS mVolleyS = null;
    //Este objeto es la cola que usará la aplicación
    private RequestQueue mRequestQueue;
    Activity activity;

    public VolleyS(Activity activity)
    {
        mRequestQueue = Volley.newRequestQueue(activity);
        this.activity=activity;
    }

    public static VolleyS getInstance(Activity activity)
    {
        if (mVolleyS == null) {
            mVolleyS = new VolleyS(activity);
        }
        return mVolleyS;
    }

    public RequestQueue getRequestQueue()
    {

        return mRequestQueue;
    }

    public void addToQueue(Request request) {
        if (request != null)
        {
            request.setTag(this);
            request.setRetryPolicy(new DefaultRetryPolicy(60000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            onPreStartConnection();
            mRequestQueue.add(request);
        }
    }



    public void onPreStartConnection() {
        activity.setProgressBarIndeterminateVisibility(true);
    }

    public void onConnectionFinished() {
        activity.setProgressBarIndeterminateVisibility(false);
    }

    public void onConnectionFailed(String error) {
        activity.setProgressBarIndeterminateVisibility(false);
        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show();
    }

}