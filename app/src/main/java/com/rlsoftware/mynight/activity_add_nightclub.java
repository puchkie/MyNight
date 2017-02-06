package com.rlsoftware.mynight;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

    private static final int PICK_IMAGE = 100;
    Uri imageUri;


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
        ClubImageButton.setOnClickListener(addImageListener);
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

    private View.OnClickListener addImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           openGallery();

        }
    };

    private void openGallery() {

        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            clubImagePreView.setImageURI(imageUri);
        }

    }

}
