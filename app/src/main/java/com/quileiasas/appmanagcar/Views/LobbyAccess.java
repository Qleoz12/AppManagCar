package com.quileiasas.appmanagcar.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.R;


public class LobbyAccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby_access);
    }

    public void movevehiculos(View view)
    {
        DataHolder.getInstance().setActivity(this);
        DataHolder.getInstance().gotoListVehiculos();
    }

    public void movePersonas(View view)
    {
        DataHolder.getInstance().setActivity(this);
        DataHolder.getInstance().gotoListPersonas();
    }

    public void movediseno(View view)
    {
        DataHolder.getInstance().setActivity(this);
        DataHolder.getInstance().gotoDiseno();
    }
}
