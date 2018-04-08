package com.websitesinseattle.trueorfalse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends Activity implements View.OnClickListener {

    //declare variables for widgets
    private Button restart;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //set references
        restart = findViewById(R.id.button);
        scoreText = findViewById(R.id.final_id);

        //set listeners
        restart.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("scoreID");
        String finalScore = Integer.toString(score);
        scoreText.setText(finalScore);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(),
                QuizActivity.class));
    }
}
