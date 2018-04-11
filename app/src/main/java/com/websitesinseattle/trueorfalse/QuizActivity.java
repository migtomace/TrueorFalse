package com.websitesinseattle.trueorfalse;

import android.app.ActionBar;
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
    int qLength = questions.length;

    int score = 0;
    boolean answer = false;

    //set up the prefs
    private SharedPreferences prefs;

    //create string array of questions
    public static String[] questions = new String[] {
            "The \"funny bone\" is really a bone.",
            "The mosquito has caused more human deaths than any other creature in history.",
            "Fingernails and hair continue to grow after death.",
            "Russia has the largest area of any country in the world.",
            "Harry Potter's archenemy is Tom Marvolo Riddle.",
            "Corn is the most produced crop in the world."
    };

    // boolean array of answers
    public static boolean[] answers = new boolean[] {
            false, true, false, true, true, true
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //set action bar icon
        getActionBar();
        ActionBar actionBar = getActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);

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
        //if the question reaches the length of questions then start new activity
        //otherwise set new question
        if (count == questions.length){
            //send variables to results activity and start results activity
            Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("scoreID", score);
            bundle.putInt("qLength", qLength);
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
            //if the false button is pressed and the answer is false add to score
            case R.id.falseID:
                answer = false;
                if (answer == answers[count-1]){
                    recordScore();
                }
                nextQuestion();
                break;

            //if the true button is pressed and the answer is true add to score
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
