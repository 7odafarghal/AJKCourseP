package com.algohinys.ajkcoursep;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {
    int countere = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            TextView counter = findViewById(R.id.counter);
            countere = savedInstanceState.getInt("countere");
            counter.setText(Integer.toString(countere));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("countere",countere);
    }


    @SuppressLint("SetTextI18n")
    public void ShowMessage(View view){
        Button show = findViewById(R.id.button);
        TextView counter = findViewById(R.id.counter);
        countere++;
        if((countere%2)==0) show.setText(R.string.ajkcoursep_first_button2);
        else show.setText(R.string.ajkcoursep_first_button);
        counter.setText(Integer.toString(countere));
    }
    public void OpenActivity(View v){
        Spinner chooseActivity = findViewById(R.id.choose_activity);
        if(chooseActivity.getSelectedItem().toString().equals("Beer Advice")){
            Intent intent = new Intent(this,BeerAdviceActivity.class);
            startActivity(intent);
        }
        if(chooseActivity.getSelectedItem().toString().equals("My Messenger")){
            Intent intent = new Intent(this,MyMessengerActivity.class);
            startActivity(intent);
        }
        if(chooseActivity.getSelectedItem().toString().equals("Stopwatch")){
            Intent intent = new Intent(this,StopwatchActivity.class);
            startActivity(intent);
        }
    }
}
