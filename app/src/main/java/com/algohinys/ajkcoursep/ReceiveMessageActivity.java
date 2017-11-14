package com.algohinys.ajkcoursep;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        TextView messageView = findViewById(R.id.message_view);
        Intent recSt =  getIntent();
        messageView.setText(
                recSt.getStringExtra("massa")
        );
    }
}
