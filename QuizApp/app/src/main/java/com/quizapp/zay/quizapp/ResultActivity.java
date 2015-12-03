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
        setSupportActionBar(toolbar);

        //get rating bar object
        RatingBar bar = (RatingBar)findViewById(R.id.ratingBar1);
        //get text view
        TextView t = (TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 1:
            case 2: t.setText("Why'd you even try?");
                break;
            case 3:
            case 4:t.setText("You Suck!");
                break;
            case 5:
            case 6:t.setText("Still only a D.");
                break;
            case 7:
            case 8:t.setText("Ok I see you.");
                break;
            case 9:
            case 10:t.setText("This is where bosses are at!");
        }
    }

// ********************* On create Method *******************************
}
