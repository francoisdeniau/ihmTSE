package com.tse.francoisdeniau.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.tse.francoisdeniau.myapplication.FormActivity.KEY_USERNAME;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewName;
    private Button buttonNext;

    public final static Integer requestCodeGetUsername = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        textViewName = findViewById(R.id.activity_main_textview_name);
        textViewName.setText("");

        buttonNext = findViewById(R.id.activity_main_button_next);
        buttonNext.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == requestCodeGetUsername){
            if(resultCode == RESULT_OK && data.getExtras() != null){
                Log.d("","");
                String name = data.getStringExtra(KEY_USERNAME);
                textViewName.setText(name);
            } else {
                //errors
            }
        }
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.activity_main_button_next:
                displayFormActivity();
                break;
        }
    }

    private void displayFormActivity(){
        Intent intent = new Intent(this, FormActivity.class);
        startActivityForResult(intent, requestCodeGetUsername);
    }
}
