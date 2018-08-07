package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;

import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.Model.vehiculo;

import java.util.ArrayList;

class BackgroundTask extends AsyncTask <Void, Void, ArrayList<vehiculo>>
 {

    private Activity activity;
    ProgressDialog progressDialog;

    public BackgroundTask(Activity activity)
    {

        this.activity=activity;
    }
     public void onAttach(Activity activity) {
         activity = activity;

         if (activity != null) {
             System.out.println("Activity---" + activity);
         }

     }

     public void onDetach() {
         activity = null;
     }

    @Override
    protected void onPreExecute()
    {

        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Cargando Listado de Carros");
        progressDialog.setMessage("limpiando polvo...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    protected void onPostExecute(ArrayList<vehiculo> result)
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                progressDialog.dismiss();
            }
        }, 3000); // 3000 milliseconds delay
    }

    @Override
    protected ArrayList<vehiculo> doInBackground(Void... params)
    {
        final vehiculoDAO Daovehiculo= new vehiculoDAO(activity);
        return   Daovehiculo.getallEnable();
    }

}