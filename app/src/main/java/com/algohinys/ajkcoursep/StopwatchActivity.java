package com.algohinys.ajkcoursep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends Activity {

    private int seconds = 0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        Intent intent = getIntent();
        if(savedInstanceState != null){
            Button button = findViewById(R.id.start_button);
            button.setText(savedInstanceState.getCharSequence("start"));
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        Button button = findViewById(R.id.start_button);
        savedInstanceState.putCharSequence("start",button.getText());
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }


    public void onClickGo(View v){
        Button button = findViewById(R.id.start_button);
        if(running){
            running = false;
            button.setText(R.string.stopwatch_start);
        }
        else {
            running = true;
            button.setText(R.string.stopwatch_stop);
        }
    }
    public void onClickReset(View v){
        Button start = findViewById(R.id.start_button);
        running = false;
        seconds = 0;
        start.setText(R.string.stopwatch_start);
    }
    private void runTimer(){
        final TextView timeView = findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
