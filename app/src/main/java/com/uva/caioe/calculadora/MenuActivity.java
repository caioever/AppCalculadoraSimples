package com.uva.caioe.calculadora;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {
    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionSobre:
                Intent SobreActivity = new Intent(this, SobreActivity.class);
                startActivity(SobreActivity);
                return true;
            case R.id.actionBases:
                Intent ConvActivity = new Intent(this, ConvActivity.class);
                startActivity(ConvActivity);
                return true;
            case R.id.actionCalc:
                Intent MainActivity = new Intent(this, MainActivity.class);
                startActivity(MainActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

