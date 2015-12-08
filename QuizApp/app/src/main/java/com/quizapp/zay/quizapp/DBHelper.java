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
        Question q1 = new Question("Design Patterns",
                "Use cases",
                "Use patterns",
                "Component System",
                "Provides a scheme for refining the subsystems or " +
                        "components of a software system, or the relationships between them:");
        this.addQuestion(q1);
        Question q2 = new Question(
                "Compose objects to realize new functionality",
                "Composition Only can be changed at compile-time",
                "Concerned with composing patterns to form larger structures",
                "Generalization-specialization is not used to compose interfaces or classes",
                "Structural patterns, which is a correct statement?");
        this.addQuestion(q2);
        Question q3 = new Question(
                "Need to use an existing class, but its interface does not match the one I need",
                "Create a reusable class that cooperates with related or foreseen classes",
                "Need to use several existing classes and it is practical to adapt their" +
                        " interface by subclassing every one ",
                "When we need a new class that has nothing to do with anything else",
                "When do we use an adapter class?");
        this.addQuestion(q3);
        Question q4 = new Question("Compose objects into tree structures to represent whole-part" +
                " hierarchies",
                "Clients treat individual objects and compositions differently",
                "Compose objects into array structures to represent whole-part hierarchies",
                "Example:Pictures can't include other pictures",
                "What is a true statement about a Composite (General hierarchy)?");
        this.addQuestion(q4);
        Question q5 = new Question("Provide a surrogate or placeholder for another object to control" +
                " access to it",
                "Provide a child class for another object to control access to it",
                "Proxies don't implement the well-known interface. ",
                "Proxies only communicate with the server, not with the client",
                "What is the intent of a proxy?");
        this.addQuestion(q5);
        Question q6 = new Question("Assignment of responsibilities between objects",
                "complex control-flow that is difficult to follow at compile-time",
                "Lets you concentrate on how objects are different",
                "Use inheritance to distribute behavior between fewer classes",
                "Behavioral patterns are concerned with:");
        this.addQuestion(q6);
        Question q7 = new Question("Defines a one-to-many dependency between objects so that when" +
                " one object changes state, all its dependents are notified and updated automatically",
                "It is not about maintaining consistency between related objects",
                "Defines a many-to-many dependency between objects so that when one object changes " +
                        "state, all its dependents are notified and updated automatically",
                "The patterns named Dependents or publish-subscribe are different patterns",
                "What is true about the Observer pattern?");
        this.addQuestion(q7);
        Question q8 = new Question("When an abstraction has two aspects, one dependent on the other," +
                " encapsulate these aspects in separate objects. That lets you vary and reuse them independently.",
                "When a change to one object requires changing others, and you already know how many" +
                        " objects need to be changed",
                "When an object should be able to notify other objects by making assumptions about " +
                        "who these objects are. You want objects tightly coupled",
                "When an abstraction has two aspects, not dependent on each other, encapsulate these" +
                        " aspects in separate objects. That lets you vary and reuse them independently.",
                "What is the correct statement regarding the Observer pattern's applicability?");
        this.addQuestion(q8);
        Question q9 = new Question("Subject, Observer, ConcreteSubject, ConcreteObserver",
                "Subject, Observer, ConcreteSubject, ConcreteObserver,Collaborations",
                "Subject, Observer",
                "ConcreteSubject, ConcreteObserver",
                "Who are the participants in the observer pattern?");
        this.addQuestion(q9);
        Question q10 = new Question("Support for broadcast communication",
                "Not many unexpected updates",
                "very tightly coupled",
                "Subject and Observer belong to the same layer of abstraction",
                "The consequences of the observer pattern include:");
        this.addQuestion(q10);
        Question q11 = new Question("The intent is to provide a way to access the elements of an " +
                "aggregate object sequentially without exposing its underlying representation",
                "Cursor is a different pattern entirely",
                "The motivation is to always traverse in the same way",
                "The intent is to provide a way to access the elements of an aggregate object " +
                        "randomly by exposing its underlying representation",
                "What is true about the iterator pattern?");
        this.addQuestion(q11);
        Question q12 = new Question("All of these answers",
                "To access the aggregate object’s contents without exposing the internal representation",
                "To support multiple traversals of aggregate objects",
                "To provide a uniform interface for traversing different aggregate structures (polymorphic iteration)",
                "What is a correct statement about the applicability of the iterator pattern?");
        this.addQuestion(q12);
        Question q13 = new Question("Iterator - Defines an class for accessing and traversing elements",
                "ConcreteIterator - Implements the Iterator interface",
                "Aggregate - Defines an interface for creating an Aggregator object",
                "ConcreteAggregate - Implements the Iterator creation interface to return an interface of the proper ConcreteIterator",
                "What is the correct definition of a participant in the iterator pattern?");
        this.addQuestion(q13);
        Question q14 = new Question("Dangerous to modify the aggregate while traversing",
                "Simple to modify the aggregate while traversing",
                "A copy and traverse is not expensive",
                "Dangerous to modify the iterator while traversing",
                "What are the implementation issues with an iterator?");
        this.addQuestion(q14);
        Question q15 = new Question("Abstract the instantiation process",
                "Make system dependent on how objects are created, composed and represented",
                "Object creational pattern uses inheritance to vary the class that is instantiated",
                "Object creational pattern doesn't delegate instantiation to another object",
                "What is true about creational patterns?");
        this.addQuestion(q15);
        Question q16 = new Question("They all encapsulate knowledge about which concrete classes the system uses",
                "They  don't hide how instances of these classes are created and put together",
                "All the system at large knows about the objects is their abstract classes as defined by interfaces",
                "Lack of flexibility",
                "Which is a recurring theme in creational patterns?");
        this.addQuestion(q16);
        Question q17 = new Question("Have a reusable framework that needs to create objects",
                "Have a reusable framework that needs to create interfaces",
                "Class of objects doesn't depend on specific application",
                "You want to change the framework using this pattern",
                "What is true about the abstract factory pattern?");
        this.addQuestion(q17);
        Question q18 = new Question("Ensure a class only has one instance",
                "Ensure a class has one to many instances",
                "It makes the class responsible for keeping track of its many instances",
                "An example is one to many window managers",
                "What is true about the singleton pattern?");
        this.addQuestion(q18);
        Question q19 = new Question("Implementation class model",
                "UML design class models",
                "UML abstraction model",
                "UML domain model",
                "Which UML Class diagram type has the highest level of detail");
        this.addQuestion(q19);
        Question q20  = new Question("Model the dynamic aspects of a software system",
                "Help you to visualize the code of the system",
                "Can't be built from a use case and a class diagram. ",
                "They show how a class will accomplish the required interactions with an actor.",
                "What is true about sequence diagrams?");
        this.addQuestion(q20);
        Question q21 = new Question("Instances of classes, Actors, Messages",
                "Just actors and objects",
                "use case digrams",
                "sequences of code",
                "The elements found in a sequence diagram include");
        this.addQuestion(q21);
        Question q22 = new Question("The steps of a use case or the steps of some other piece of functionality",
                "The steps of a use case",
                "The steps of some other piece of functionality",
                "Sequence diagrams don't show communication",
                "Sequence diagrams show how a set of actors and objects communicate with each other to perform:");
        this.addQuestion(q22);
        Question q23 = new Question("An iteration over objects is indicated by an asterisk preceding the message name",
                "If an object’s life ends, this is shown with an ! at the end of the lifeline ",
                "A vertical line, called a lifestream, is attached to each object or actor. ",
                "The objects are arranged vertically across the diagram. ",
                "The elements found in a sequence diagram include");
        this.addQuestion(q23);
        Question q24 = new Question("An iteration over objects is indicated by an asterisk preceding the message name",
                "If an object’s life ends, this is shown with an ! at the end of the lifeline ",
                "A vertical line, called a lifestream, is attached to each object or actor. ",
                "The objects are arranged vertically across the diagram. ",
                "What is true about sequence diagrams?");
        this.addQuestion(q24);
        Question q25 = new Question("Who will be using the system?",
                "How is it going to be advertised?",
                "How long will it be used?",
                "What will the code look like?",
                "What is a key thing to keep in mind with interaction design?");
        this.addQuestion(q25);
        Question q26 = new Question("Visibility, feedback,contraints, Consistency, Affordances",
                "Visibility, feedback,contraints, variability",
                "contraints, Consistency, Affordances, restrictions",
                "Visibility, Consistency",
                "Design principles include:");
        this.addQuestion(q26);
        Question q27 = new Question("Framed as measurable questions.",
                "How useful/productive a system is from an economic perspective.",
                "How visually pleasing the system is",
                "How new the system looks",
                "What is true about usability?");
        this.addQuestion(q27);
        Question q28 = new Question("All of these answers",
                "Effectiveness – how well does the system do what it is supposed to do?",
                "Efficiency – how are users supported in doing their tasks?",
                "Safety – protect from dangerous/undesirable situations.",
                "Usability goals include:");
        this.addQuestion(q28);
        Question q29 = new Question("Can include positive or negative qualities",
                "Experience is from the system's point of view",
                "Is all measurable qualities",
                "Does not include qualities like satisfying, fun, or provacative",
                "What is true about user experience?");
        this.addQuestion(q29);
        Question q30 = new Question("May need different versions for different usertypes/populations",
                "Ordering of questions can't influence response",
                "Shouldn't provide instructions",
                "Always use check boxes instead of Likert scales or semantic differential scales",
                "Which is a true statement about questionaires?");
        this.addQuestion(q30);
        Question q31 = new Question("Objective of use case analysis is to model the" +
                " system from the point of view of how users interact with this system",
                "is an atypical sequence of actions that a user might perform",
                "consists of one use case",
                "A description or diagram indicating how use cases are related is always required",
                "Use case models of systems:");
        this.addQuestion(q31);
        Question q32 = new Question("a use case should cover the full sequence of steps from the beginning of a task until the end.",
                "A use case should describe the user’s interaction with the system and what happens in the code",
                "A use case should be dependant on the user interface design",
                "A use case should include actions in which the computer interacts with the system",
                "What is true about use cases?");
        this.addQuestion(q32);
        Question q33 = new Question("They can help to define the scope of the system",
                "They only need to validate requirements",
                "They are often used after planing the development process",
                "They can be built off of a specific U",
                "The benefits of basing software development on use cases include:");
        this.addQuestion(q33);
        Question q34 = new Question("a specific occurrence of the use case",
                "a broad category of actors",
                "many times the use case could happen",
                "All of the types of data that could occur",
                "A scenario is an instance of a use case it expresses");
        this.addQuestion(q34);
        Question q35 = new Question("Unrelated use cases",
                "Preconditions: State of the system before the use case.",
                "Postconditions: State of the system in following completion.",
                "Steps: Describe each step using a 2-column format.",
                "Which of these is not in a use case description");
        this.addQuestion(q35);
        Question q36 = new Question("Identify actors related to a system or organization",
                "For each actor, identify the processes they don't participate in",
                "Identify the external events that a system must respond to",
                "Relate the events to actors and use cases",
                "What is true about the actor-based method of identifying use cases");
        this.addQuestion(q36);
        Question q37 = new Question("Identify the external events that a system must respond to",
                "Identify actors related to a system or organization",
                "For each actor, identify the processes they initiate or participate in",
                "Don't relate the events to actors and use cases",
                "What is true about the event-based method of identifying use cases");
        this.addQuestion(q37);
        Question q38 = new Question("Only identify one actor",
                "Take an actor and actor-goal perspective",
                "Choose the system boundary",
                "Define use cases that satisfy the user goals",
                "What is not a guideline for creating use cases");
        this.addQuestion(q38);
        Question q39 = new Question("Used to make optional interactions explicit or to handle exceptional cases.",
                "By creating separate use case extensions, the description of the basic use case gets more complex.",
                "An extension only needs to list some of the steps",
                "Extensions should not handle any unusual situations",
                "What is a correct statement about use case extensions?");
        this.addQuestion(q39);
        Question q40 = new Question("A generalized use case represents one use case.",
                "Much like superclasses in a class diagram.",
                "A generalized use case represents several similar use cases.",
                "One or more specializations provides details of the similar use cases.",
                "What is incorrect about generalizations?");
        this.addQuestion(q40);
        Question q41 = new Question("tertiary - processes that will probably not happen",
                "Primary - major common processes",
                "Secondary - minor or rare processes",
                "Optional - processes that may not be tackled",
                "Which is not a type of use case");
        this.addQuestion(q41);
        Question q42 = new Question("A use case can't have more than one scenario ",
                "Good to describe use cases independent of implementation",
                "Need to document failure scenarios (what if credit card fails)",
                "Should agree on a “format style” for use case description",
                "What is not true about use cases");
        this.addQuestion(q42);
        Question q43 = new Question("High ranking use cases need to be tackled in the early cycles",
                "Before all use cases are known, transition to iterative development cycle",
                "High ranking use cases need to be tackled in the late cycles",
                "First pick use cases that don't significantly influence the core architecture",
                "What is true about ranking and scheduling use cases?");
        this.addQuestion(q43);
        Question q44 = new Question("Doesn't involve significant research, or new and risky technology",
                "Significant impact on architectural design ",
                "Involve significant research, or new and risky technology",
                "Represent primary line-of-business processes",
                "Which of these is not a quality that increases a use case ranking?");
        this.addQuestion(q44);
        Question q45 = new Question("Only code can be inspected",
                "effectively find defects with an efficient use of people",
                "Any artifact can be inspected",
                "The requirements can be inspected",
                "What is not true about inspections?");
        this.addQuestion(q45);
        Question q46 = new Question("In code, after successful compilation",
                "In code, after developer testing",
                "In requirements after design or user feedback",
                "In design after formal checking (model, theorum proving,...)",
                "When should you use inspections?");
        this.addQuestion(q46);
        Question q47 = new Question("provide implementation details",
                "use a standard notation ",
                "be understandable by clients and users ",
                "provide abstraction",
                "What should a UML model not do?");
        this.addQuestion(q47);
        Question q48 = new Question("represent the concepts in the problem domain, and their relationships",
                "represent the classes in the solution",
                "represent the actual classes used in the program",
                "can be obtained using reverse engineering tools",
                "UML domain models:");
        this.addQuestion(q48);
        Question q49 = new Question("Implementation class model " +
                "represent the actual classes used in the program and can be obtained using reverse engineering tools",
                "can't be obtained using reverse engineering tools",
                "represent the concepts in the problem domain, and their relationships",
                "represent the concepts in the design domain",
                "Implementation class model");
        this.addQuestion(q49);
        Question q50 = new Question("There must be exactly one instance of a class",
                "Must not be accessible to clients from a well-known access point",
                "when the sole instance should be extensible by subclassing, and clients" +
                        " should be able to use an extended instance by modifying code",
                "There must be at least one instance of a class",
                "What is a correct statement about the applicablilty of the singleton pattern?");
        this.addQuestion(q50);
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
