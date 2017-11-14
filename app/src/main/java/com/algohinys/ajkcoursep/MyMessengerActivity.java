package com.algohinys.ajkcoursep;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MyMessengerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_messenger);
        Intent intent = getIntent();
    }

    public void onSendMessage(View v){
        EditText message = findViewById(R.id.enter_message);
        Spinner spin = findViewById(R.id.int_ent);
        if(spin.getSelectedItem().toString().equals("view")){
            Intent intent = new Intent(this,ReceiveMessageActivity.class);
            intent.putExtra(
                    "massa", message.getText().toString()
            );
            startActivity(intent);
        }
        else{
            Intent snd = new Intent(Intent.ACTION_SEND);
            snd.setType("text/plain");
            snd.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
            Intent chosen = Intent.createChooser(snd,getString(R.string.mymessenger_chooser));
            startActivity(chosen);
        }

    }
}
