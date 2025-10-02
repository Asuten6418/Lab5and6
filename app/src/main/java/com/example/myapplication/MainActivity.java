package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button addbutton, browseButtonNote;
    ImageView logo;
    ProgressBar FrontPageBar1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addbutton = findViewById(R.id.AddNoteBTN);
        logo = findViewById(R.id.imageView);
        logo.setImageResource(R.drawable.img);

        FrontPageBar1 = findViewById(R.id.progressBarMain);
        FrontPageBar1.setVisibility(View.GONE);

        addbutton.setOnClickListener(new View.OnClickListener() { //event listener
            @Override
            public void onClick(View v) { //event handler
                System.out.println("Click!");
                Intent addNote2Act = new Intent(getApplicationContext(),addnote2.class);
                startActivity(addNote2Act);
            }
        });

        browseButtonNote = findViewById(R.id.BrowseNoteBTN);
        browseButtonNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FrontPageBar1.setVisibility(View.VISIBLE);
                new Thread(() -> {
                    //delay 2 sec
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //load data from database
                    // -
                    //back to main thread
                    runOnUiThread(() -> {
                        //remove progressbar
                        FrontPageBar1.setVisibility(View.GONE);
                        //go to DisplayNoteAct
                        Intent displayNoteAct = new Intent(getApplicationContext(), BrowseNote.class);
                        startActivity(displayNoteAct);
                    });
                }).start();

            }
        });


    }

}


    /*
    public static void main(String[] args) {

    Note Note1 = new Note();
    Note Note2 = new Note();
    User User1 = new User();
    User User2 = new User();

    Note1.title = "wonderrideBook";
    Note1.createdDate = "15/4/2565";

    Note2.title = "wonder";
    Note2.createdDate = "4/4/2566";
    User1.UserName = "Mordredkaiser";
    User1.password = "Mordred";

       User2.UserName = "SHio";
       User2.password = "Hiseki";
    }
    */