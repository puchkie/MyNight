package com.rlsoftware.mynight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /////
    //Variables

    Button btnNightClubs;
    Button btnAddNightclub;
    Button btnEscapeRooms;
    Button btnPubs;

    TextView tvTitle;

    /////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////
        //References

        btnNightClubs = (Button) findViewById(R.id.btnNightClub);
        btnAddNightclub = (Button) findViewById(R.id.btnAddNightClub);
        btnEscapeRooms = (Button) findViewById(R.id.btnEscapeRoom);
        btnPubs = (Button) findViewById(R.id.btnPubs);

        /////

        /////
        //Listeners
        btnNightClubs.setOnClickListener(btnNightClubsListener);
        /////
    }


    private View.OnClickListener btnNightClubsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i = new Intent(MainActivity.this,activity_add_nightclub.class);
            startActivity(i);
        }
    };




}
