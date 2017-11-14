package com.algohinys.ajkcoursep;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class BeerAdviceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_advice);
        Intent intent = getIntent();
    }
    public void OnClickFindBeer(View v){
        TextView brands = findViewById(R.id.brands);
        Spinner colors = findViewById(R.id.select_beer_color);
        brands.setText(
                getBrands(
                        String.valueOf(colors.getSelectedItem())
                )
        );
    }

    String getBrands(String clr){
        switch (clr){
            case "light": return "Jack Amber\nRed Moose";
            case "amber": return "Vodka\nMartini";
            case "brown": return "Scotch\nCorona";
            case "dark": return "Beer\nChampagne";
            default: return "no such beer color";
        }
    }
}

