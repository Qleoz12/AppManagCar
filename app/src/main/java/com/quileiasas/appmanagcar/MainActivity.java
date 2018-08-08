package com.quileiasas.appmanagcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.Controller.SyncTask;

public class MainActivity extends AppCompatActivity {

    SyncTask Soblj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set second paramer to time in miliseconds 10 s
        Soblj= new SyncTask(this,10000);

    }



    public void move(View view)
    {
        DataHolder.getInstance().setActivity(MainActivity.this);
        DataHolder.getInstance().gotoLobby();
    }
}
