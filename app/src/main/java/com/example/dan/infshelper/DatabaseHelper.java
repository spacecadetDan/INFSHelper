package com.example.dan.infshelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    //Declare table name and columns
    private static final String TABLE_NAME = "score_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "score";
    private static final String COL3 = "topicName";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL2 + " INTEGER," + COL3 + " TEXT)";
        db.execSQL(createTable);
        //Create 8 rows of empty scores at database inception
        addInitialData(db, 0, "Java fundamentals");
        addInitialData(db, 0, "Inheritance and abstract classes");
        addInitialData(db, 0, "Polymorphism and interfaces");
        addInitialData(db, 0, "JavaFX");
        addInitialData(db, 0, "Exception handling");
        addInitialData(db, 0, "Event-driven programming");
        addInitialData(db, 0, "Databases");
        addInitialData(db, 0, "Review");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Check if table exists on start
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addInitialData(SQLiteDatabase db, int item, String name) {
        ContentValues contentValues = new ContentValues();
        //Insert the two topic and initial score columns
        contentValues.put(COL2, item);
        contentValues.put(COL3, name);

        Log.d(TAG, "addData: Adding INITIAL VALUES " + name + " " + item + " to " + TABLE_NAME);
        //insert into database
        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data has inserted incorrectly this will return -1
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addData(int item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);


        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data has inserted incorrectly this will return -1
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }

    //Get all of the database items
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Inserts new score
     *
     * @param newScore
     * @param id       is the id of the topic
     */
    public void updateScore(int id, int newScore) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newScore + "' WHERE " + COL1 + " = '" + id + "'";
        Log.d(TAG, "updateScore: query: " + query);
        Log.d(TAG, "updateScore: Setting score to " + newScore);
        db.execSQL(query);
    }

}
