package com.rlsoftware.mynight;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class NightClubActivity extends ListActivity {

    public static final String ROW_ID = "row_id"; // intent extra key

    private ListView nightclubListView;

    //adapter for listview
    private SimpleCursorAdapter myNightClubSimpleCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_club);

        nightclubListView = getListView();// get the built in ListView

        nightclubListView.setOnItemClickListener(NCitemClickListener);


    }

    private AdapterView.OnItemClickListener NCitemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

    //TODO Finish Class




}
