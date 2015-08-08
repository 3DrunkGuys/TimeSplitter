package com.threedrunkguys.timesplitter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Andrew on 8/7/2015.
 *
 * Manages all interactions with the data base.
 */
public class DBHandler {
    private static DBHandler dbHandler;
    private SQLiteDatabase db;

    public static final String TABLE_PROJECTS = "projects";
    public static final String KEY_ID = "id";

    public static final String PROJECT_NAME = "project_name";
    public static final String PROJECT_NOTE = "project_note";

    private static final String CREATE_TABLE_PROJECT = "CREATE TABLE " + TABLE_PROJECTS
            + "(" + KEY_ID + " INTEGER PRIMARY KEY," + PROJECT_NAME + " TEXT,"
            + PROJECT_NOTE + " TEXT" + ")";

    private DBHandler(Context context){
        db = context.openOrCreateDatabase("DATABASE", android.content.Context.MODE_PRIVATE, null);

        db.execSQL(CREATE_TABLE_PROJECT);
    }

    public static DBHandler getDbHandler(Context context){
        if(dbHandler == null)
            dbHandler = new DBHandler(context);

        return dbHandler;
    }

    public long createProject(String projectName, String projectNote){
        ContentValues values = new ContentValues();
        values.put(PROJECT_NAME, projectName);
        values.put(PROJECT_NOTE, projectNote);

        return db.insert(TABLE_PROJECTS, null, values);
    }

    public void deleteProject(long projectID){
        db.delete(TABLE_PROJECTS, KEY_ID + " =?", new String[]{String.valueOf(projectID)});
    }
}