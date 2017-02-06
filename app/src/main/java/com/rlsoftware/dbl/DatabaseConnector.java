package com.rlsoftware.dbl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Roei on 26/01/2017.
 */

public class DatabaseConnector { //DAL

    //DB name
    private static final String DATABASE_NAME = "mynightdb";

    private SQLiteDatabase database; //database object
    private MyDatabase databaseOpenhelper; // database helper

    // db constructor

    public DatabaseConnector(Context context){
        databaseOpenhelper = new MyDatabase(context, DATABASE_NAME, null, 1);
    }

    //open db connection
    public void open() throws SQLException{
        //create or open db for read/write
        database = databaseOpenhelper.getWritableDatabase();
    }

    //close db connection
    public void close(){
        if (database != null){
            database.close(); // closes db connection
        }
    }

    //insert new club
    public void insertNewClub(String club_name, String club_img, String club_nextdate){
        ContentValues newClub = new ContentValues();
        newClub.put("club_name", club_name);
        newClub.put("club_img", club_img);
        newClub.put("club_nextdate", club_nextdate);

        open();
        //null to inform android that there is no col id to be null
        database.insert("nightclubs", null, newClub);
        close();
    }

    public Cursor getAllClubs(){
        open();
        Cursor c = database.rawQuery("select * from nightclubs", null);

        return c;

}
}
