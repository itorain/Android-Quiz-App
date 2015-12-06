package com.quizapp.zay.quizapp;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zay on 12/3/2015.
 * This class creates a database of questions to pull from. It works by creating a database on
 * create then updates the questions in the database. This class extends db helper because it
 * makes it mucher easier to create the db. more info can be found here
 * http://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html
 */
public class DBHelper extends SQLiteOpenHelper {
// ******** Instance variables *************

    private static final int DATABASE_VERSION = 1;
    // Name of DB
    private static final String DATABASE_NAME = "quizQuestions";
    // table name
    private static final String TABLE_QUEST = "questions";
    // Table Columns
    private static final String ID = "id";
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String OPTA= "opta";
    private static final String OPTB= "optb";
    private static final String OPTC= "optc";
    private SQLiteDatabase db;

// ******** Instance variables *************

/******** Constructor **********************************************
     * Constructor that creates DB helper.
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getReadableDatabase();
    }

// ******** Constructor ********************************************

// ******** Instance methods ***********************
    // This method creates the db.
    @Override
    public void onCreate(SQLiteDatabase datab) {
        db = datab;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTION
                + " TEXT, " + ANSWER + " TEXT, " + OPTA +" TEXT, "
                + OPTB + " TEXT, " + OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }

    // this method will recreate db if one already exists so no duplicates.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // This method adds the questions to the database. Add questions here in form below.
    private void addQuestions() {
        Question q1 = new Question("SuSe", "OSX", "DOS", "BIOS","Which of the following is NOT " +
                "an operating system?");
        this.addQuestion(q1);
        Question q2 = new Question("Spiral","Waterfall", "Extreme", "Agile", "What is the most " +
                "widely used development technique?");
        this.addQuestion(q2);
        Question q3 = new Question("RAM", "FLASH","SSD","Register","Which of the following is the " +
                "fastest writable memory?");
        this.addQuestion(q3);
        Question q4 = new Question("Wifi", "Bridge", "Hub","Router","Which of the following device" +
                " regulates internet traffic?");
        this.addQuestion(q4);
        Question q5 = new Question("Ruby","Python","Java","BASIC","Which of the following is NOT an" +
                " interpreted language?");
        this.addQuestion(q5);
        Question q6 = new Question("Boulder","Fort Collins","Colorado Springs","Denver","What is the " +
                "capital of Colorado?");
        this.addQuestion(q6);
        Question q7 = new Question("Get a watch","7:30?","idk","Game Time!","What time is it!?");
        this.addQuestion(q7);
        Question q8 = new Question("Thats not false","Pick True","False","True","CSU costs too much");
        this.addQuestion(q8);
        Question q9 = new Question("Coors","CooperSmiths","Odell","New Belgium","Who has the best beer?");
        this.addQuestion(q9);
        Question q10 = new Question("Lavander","Pink","Red","Blue","What color is the sky?");
        this.addQuestion(q10);
        Question q11 = new Question("Walkie Talkie","idk","pager","Cellphone","I used to call " +
                "you on my ___");
        this.addQuestion(q11);
    }

    // This method adds a single new question.
    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(QUESTION, quest.getQuestion());
        values.put(ANSWER, quest.getAnswer());
        values.put(OPTA, quest.getOptA());
        values.put(OPTB, quest.getOptB());
        values.put(OPTC, quest.getOptC());
        // Insert question into db
        db.insert(TABLE_QUEST, null, values);
    }

    // This method returns an arraylist of all the questions.
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        //db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOptA(cursor.getString(3));
                quest.setOptB(cursor.getString(4));
                quest.setOptC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

// ******** Instance methods ************************
}
