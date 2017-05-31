package com.uva.caioe.calculadora;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

public class SobreActivity extends MenuActivity{

    private LinearLayout layoutAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        layoutAbout = (LinearLayout) findViewById(R.id.layoutAbout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.actionSobre);

    }

}
