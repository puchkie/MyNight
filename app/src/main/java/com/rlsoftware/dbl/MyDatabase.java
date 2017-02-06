package com.rlsoftware.dbl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Roei on 26/01/2017.
 */

public class MyDatabase extends SQLiteOpenHelper {


    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // query to create new table named nightclubs
        String createQuery = "CREATE TABLE `nightclubs` (" +
                "`club_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`club_name` TEXT NOT NULL," +
                "`club_img` BLOB," +
                "`club_nextdate` TEXT);";

        db.execSQL(createQuery); //execute the query

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
