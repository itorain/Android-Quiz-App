package com.quizapp.zay.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
// ******** Instance variables *************

    ArrayList<Question> questionList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView textQuestion;
    RadioButton rda, rdb, rdc, rdanswer;
    FloatingActionButton next;
    FloatingActionButton answer; // Currently unimplemented
    FloatingActionButton prev; // Currently unimplemented
    Button finish;

// ******** Instance variables *************

// ******************** On create Method *******************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DBHelper database = new DBHelper(this);
        questionList = database.getAllQuestions();
        currentQ = questionList.get(qid);
        textQuestion = (TextView)findViewById(R.id.textView1);
        rda =(RadioButton)findViewById(R.id.radio0);
        rdb =(RadioButton)findViewById(R.id.radio1);
        rdc =(RadioButton)findViewById(R.id.radio2);
        rdanswer = (RadioButton)findViewById(R.id.radioAnswer);
        next = (FloatingActionButton)findViewById(R.id.next);
        answer = (FloatingActionButton)findViewById(R.id.answer);
        prev = (FloatingActionButton)findViewById(R.id.back);
        finish = (Button)findViewById(R.id.finish);
        //Random randomGenerator = new Random();
        setQuestionView();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton enteredAnswer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                //Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getAnswer().equals(enteredAnswer.getText())) {
                    score++;
                    Log.d("score", "Your score" + score);
                }
                if (qid < 10) {
                    currentQ = questionList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
                finish();
            }
        });
    }
// **************************** On create Method *******************************

// ********* Set up new question view method ******************

    private void setQuestionView()
    {
        textQuestion.setText(currentQ.getQuestion());
        rda.setText(currentQ.getOptA());
        rdb.setText(currentQ.getOptB());
        rdc.setText(currentQ.getOptC());
        qid++;
    }

// ********* Set up new question view method *******************

}
