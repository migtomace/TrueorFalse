package com.websitesinseattle.trueorfalse;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create references
        startButton = findViewById(R.id.startID);

        //create listeners
        startButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),
                QuizActivity.class));
    }
}
