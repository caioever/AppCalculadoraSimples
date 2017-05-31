package com.uva.caioe.calculadora;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ConvActivity extends MenuActivity {

    //Campo de bases
    private LinearLayout layoutConvert;
    private TextView tvResposta;
    private Button btBin;
    private Button btOct;
    private Button btHex;
    private EditText etDecimal;

    //Operações de base
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        layoutConvert = (LinearLayout) findViewById(R.id.layoutConvert);

        //converção de base
        tvResposta = (TextView) findViewById(R.id.tvResposta);
        btBin = (Button) findViewById(R.id.btBin);
        btOct = (Button) findViewById(R.id.btOct);
        btHex = (Button) findViewById(R.id.btHex);
        etDecimal = (EditText) findViewById(R.id.etDecimal);


        //Operações de base
        btBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String out = Integer.toBinaryString(Integer.parseInt(etDecimal.getText().toString()));
                tvResposta.setText(out);
            }
        });
        btOct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String out = Integer.toOctalString(Integer.parseInt(etDecimal.getText().toString()));
                tvResposta.setText(out);
            }
        });
        btHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String out = Integer.toHexString(Integer.parseInt(etDecimal.getText().toString()));
                tvResposta.setText(out);
            }
        });
    }
}
