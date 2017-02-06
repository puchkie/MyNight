package com.rlsoftware.mynight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.rlsoftware.dbl.DatabaseConnector;

public class activity_add_nightclub extends AppCompatActivity {

    EditText ETClubName, ETclubNextDate;

    ImageView clubImagePreView;

    Button btnSaveNightClub, ClubImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nightclub);

        ETClubName = (EditText) findViewById(R.id.ETClubName);
        ETclubNextDate = (EditText) findViewById(R.id.ETnextDate);

        ClubImageButton = (Button) findViewById(R.id.ClubImageButton);
        btnSaveNightClub = (Button) findViewById(R.id.btnSaveNightClub);

        clubImagePreView = (ImageView) findViewById(R.id.clubImagePreView);

        btnSaveNightClub.setOnClickListener(saveBtnListener);
    }


    private View.OnClickListener saveBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int errors = 0;
            DatabaseConnector databaseConnector = new DatabaseConnector(activity_add_nightclub.this);
            String ClubName = ETClubName.getText().toString();
            String NextDate = ETclubNextDate.getText().toString();
            if (ClubName.isEmpty()) {
                ETClubName.setError("");
                errors++;
            }
            if (NextDate.isEmpty()) {
                ETclubNextDate.setError("");
                errors++;
            }
            if (errors == 0) {
                databaseConnector.insertNewClub(ClubName, null, NextDate);
            }
        }

    };
}
