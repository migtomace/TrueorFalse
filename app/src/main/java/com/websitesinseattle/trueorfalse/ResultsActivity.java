package com.websitesinseattle.trueorfalse;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends Activity implements View.OnClickListener {

    //declare variables for widgets
    private Button restart;
    private TextView scoreText;
    private TextView feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //set action bar icon
        getActionBar();
        ActionBar actionBar = getActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);

        //set references
        restart = findViewById(R.id.button);
        scoreText = findViewById(R.id.final_id);
        feedbackText = findViewById(R.id.feedbackID);

        //set listeners
        restart.setOnClickListener(this);

        //accepts variables from the quiz activity
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("scoreID");
        int qLength = bundle.getInt("qLength");
        String finalScore = Integer.toString(score);
        String finalLength = Integer.toString(qLength);
        scoreText.setText(finalScore + " / " + finalLength);

        float perc = ((float)score) / ((float)qLength);

        if (perc == 1){
            feedbackText.setText("Wow a perfect score!");
        } else if (perc > 0.8) {
            feedbackText.setText("Congrats, you were almost there!");
        } else if (perc > 0.65) {
            feedbackText.setText("Good job!");
        } else {
            feedbackText.setText("Looks like you could use some practice.");
        }

//        switch (score){
//            case 6:
//                feedbackText.setText("Wow a perfect score!");
//                break;
//            case 5:
//                feedbackText.setText("Congrats, you were almost there!");
//                break;
//            case 4:
//                feedbackText.setText("Good job!");
//                break;
//            default:
//                feedbackText.setText("Looks like you could use some practice.");
//                break;
//        }


    }

    @Override
    public void onClick(View view) {
        //when the retake button is clicked start quiz activity
        startActivity(new Intent(getApplicationContext(),
                QuizActivity.class));
    }
}
