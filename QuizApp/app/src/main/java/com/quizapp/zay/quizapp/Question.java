package com.quizapp.zay.quizapp;

/**
 * Created by Zay on 12/3/2015.
 * This class is the quesetion class defining the question. It makes it easier to display
 * a question since all the information needed is in one class.
 */
public class Question {
// ******** Instance variables *************

    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String answer;
    private int id;

// ******** Instance variables *************

 /******** Constructors **************************************************************************
  * Default constructor and constructor that takes in all initial values
  */

    public Question() {
        question = "";
        optA = "";
        optB = "";
        optC = "";
        answer = "";
        int id = 0;
    }

    public Question(String optA, String optB, String optC, String answer, String question) {
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.answer = answer;
        this.question = question;
    }

// ******** Constructors *************************************************************************

// ******** Getters and Setters ***********************


    public String getQuestion() {
        return question;
    }

    public String getOptA() {
        return optA;
    }

    public String getOptB() {
        return optB;
    }

    public String getOptC() {
        return optC;
    }

    public String getAnswer() {
        return answer;
    }

    public int getID() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setID(int ID) {
        this.id = id;
    }

// ******** Getters and Setters ***************************
}
