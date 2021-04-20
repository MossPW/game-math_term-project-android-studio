package com.example.project_l.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


 // Created by MossMeen on 11/29/2015.

public class MyHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME = "mathmagic.db";
    private static  final int DATABASE_VERSION = 1;

    public MyHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String TABAL_NAME = "scores";
    public static final String COL_ID = "_id";
    public static final String COL_SCORE = "score";
    public static final String COL_DIFFICULTY = "difficulty";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "%s REAL,"
                + "%s INTEGER)";

        sqlCreateTable = String.format(sqlCreateTable, TABAL_NAME, COL_ID,COL_SCORE, COL_DIFFICULTY);

        db.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oleVersion, int newVersion) {
        return;
    }
}
