package com.websitesinseattle.trueorfalse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity implements View.OnClickListener {


    //declare variables for widgets
    private TextView scoreText;
    private TextView questionText;
    private Button trueButton;
    private Button falseButton;

    //set counts
    int count = 0;

    int score = 0;
    boolean answer = false;

    //set up the prefs
    private SharedPreferences prefs;

    //create string array of questions
    public static String[] questions = new String[] {
            "The \"funny bone\" is really a bone.",
            "Fingernails and hair continue to grow after death.",
            "The mosquito has caused more human deaths than any other creature in history.",
            "Russia has the largest area of any country in the world.",
            "The Enlightenment was an intellectual movement that celebrated religious faith over reason.",
            "Corn is the most produced crop in the world."
    };

    // boolean array of answers
    public static boolean[] answers = new boolean[] {
            false, false, true, true, false, true
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //set references
        scoreText = findViewById(R.id.scoreID);
        questionText = findViewById(R.id.questionID);
        falseButton = findViewById(R.id.falseID);
        trueButton = findViewById(R.id.trueID);

        //set listeners
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);

        //set first question
        nextQuestion();

        //set the score to zero
        scoreText.setText(Integer.toString(score));
    }


    public void nextQuestion(){
        if (count == questions.length){
            Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("scoreID", score);
            i.putExtras(bundle);
            QuizActivity.this.finish();
            startActivity(i);
        } else {
            questionText.setText(questions[count]);
            count++;
        }


    }
    public void recordScore(){
        score++;
        scoreText.setText(Integer.toString(score));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.falseID:
                answer = false;
                if (answer == answers[count-1]){
                    recordScore();
                }
                nextQuestion();
                break;
            case R.id.trueID:
                answer = true;
                if (answer == answers[count-1]){
                    recordScore();
                }
                    nextQuestion();
                break;
        }
    }
}
