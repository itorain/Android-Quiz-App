package com.quizapp.zay.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

/********************* On create Method *******************************
    * Displays the results of the quiz
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //get text view
        TextView numberRight = (TextView)findViewById(R.id.textView1);
        TextView totalNumOfQuestions = (TextView)findViewById(R.id.textView2);
        TextView message = (TextView)findViewById(R.id.textView3);
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        //get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        int attempted = b.getInt("attempted");
        //display score
        if (score > 10) {
            score = 10;
        }
        numberRight.setText("Number correct: " + Integer.toString(score));
        totalNumOfQuestions.setText("10 questions total. Attempted: " + Integer.toString(attempted));
        bar.setRating(score);
        switch (score)
        {
            case 0:
            case 1:
            case 2: message.setText("Why'd you even try?");
                break;
            case 3:
            case 4:message.setText("You Suck!");
                break;
            case 5:
            case 6:message.setText("Still only a D.");
                break;
            case 7:
            case 8:message.setText("Ok I see you.");
                break;
            case 9:
            case 10:message.setText("This is where bosses are at!");
        }
    }

// ********************* On create Method *******************************
}
