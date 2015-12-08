package com.quizapp.zay.quizapp;

import android.content.Context;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
// ******** Instance variables *************

    ArrayList<Question> questionList;
    int score = 0;
    int qid = 0;
    int attempted = 0;
    Question currentQ;
    TextView textQuestion;
    RadioButton rda, rdb, rdc, rdanswer;
    FloatingActionButton next;
    FloatingActionButton answer;
    FloatingActionButton prev;
    Button finish;

// ******** Instance variables *************

// ******************** On create Method *******************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper database = new DBHelper(this);
        questionList = new ArrayList<>();
        createList(database);
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
        setQuestionView();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qid < 10) {
                    currentQ = questionList.get(qid);
                    setQuestionView();
                    qid++;
                }
                else {
                    showResults();
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResults();
            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton enteredAnswer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                if (enteredAnswer == null) {
                    showToast("No answer selected!");
                    return;
                }
                if (attempted <= 10) {
                    attempted++;
                }
                if (currentQ.getAnswer().equals(enteredAnswer.getText())) {
                    score++;
                    Log.d("score", "Your score " + score);
                    showToast("Correct!");
                    if (qid == 9) {
                        showResults();
                    }
                    else {
                        currentQ = questionList.get(qid++);
                        setQuestionView();
                    }

                }
                else if (qid < 9) {
                    showToast("Incorrect!");
                    currentQ = questionList.get(qid++);
                    setQuestionView();
                }
                else {
                    showResults();
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (qid != 0) {
                    currentQ = questionList.get(qid--);
                    setQuestionView();
                }
                else {
                    showToast("No previous Quiz Question!");
                }
            }
        });

    }

// **************************** On create Method *******************************

// ********* Set up new question view method ******************

    private void setQuestionView() {
        textQuestion.setText(currentQ.getQuestion());
        rda.setText(currentQ.getOptA());// Figure out a way to randomize these
        rdb.setText(currentQ.getOptB());
        rdc.setText(currentQ.getOptC());
        rdanswer.setText(currentQ.getAnswer());
    }

// ********* Set up new question view method *******************

// ************ Create a list of 10 random questions *************

    private void createList(DBHelper database) {
        ArrayList<Question> allQuestions = database.getAllQuestions();
        Random randomGenerator = new Random();
        int index;
        for (int i = 0; i < 10; i++) {
            index = randomGenerator.nextInt(allQuestions.size());
            Question quest = allQuestions.get(index);
            questionList.add(quest);
            allQuestions.remove(quest);
        }
    }

// ************ Create a list of 10 random questions *************

//************* Show pop up message for entered answer ***********

    private void showToast(String message) {
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

//************* Show pop up message for entered answer ***********

//**************** Move to Results *************************
    private void showResults() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score); //Your score
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }
//**************** Move to Results *************************
}
