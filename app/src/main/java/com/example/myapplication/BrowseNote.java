package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrowseNote extends AppCompatActivity {

    Button BackHome,searchButtonADN;
    ProgressBar progressBarADN;
    TextView noData,showNote, ShowNoteFromAPI;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BackHome = findViewById(R.id.BackHomeDispNote);
        BackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackHomeDspN = new Intent(BrowseNote.this,MainActivity.class);
                startActivity(BackHomeDspN);

            }
        });

        progressBarADN = findViewById(R.id.progressBarDispNote);
        progressBarADN.setVisibility(View.GONE);

        searchButtonADN = findViewById(R.id.searchButtonDispNote);
        searchButtonADN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarADN.setVisibility(View.VISIBLE);
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(() -> {
                        progressBarADN.setVisibility(View.GONE);
                        System.out.println("Cl1ck");
                        noData = findViewById(R.id.SearchBarDSPN);
                        noData.setText("No data!");
                    });
                }).start();
            }
        });
        showNote = findViewById(R.id.textView2);
        ShowNoteFromAPI = findViewById(R.id.textView);

        Executors.newSingleThreadExecutor().execute(() -> {
            List<NoteEntity> entities = AppDatabase.getInstance(this).noteDao().getAll();
            List<Note> notes = new ArrayList<>();
            for (NoteEntity e : entities) {
                notes.add(NoteMapper.fromEntity(e));
            }

            runOnUiThread(() -> {
                StringBuilder sb = new StringBuilder();
                for (Note n : notes) {
                    sb.append(n.display()).append("\n");
                }
                showNote.setText(sb.toString());
            });
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIservice apiService = retrofit.create(APIservice.class);
        Call<List<textNote>> call = apiService.getTextNote();

        call.enqueue(new Callback<List<textNote>>() {
            @Override
            public void onResponse(Call<List<textNote>> call, Response<List<textNote>> response) {
                if (!response.isSuccessful()) {
                    ShowNoteFromAPI.setText("Error Code: " + response.code());
                    return;
                }

                List<textNote> notes = response.body();
                StringBuilder builder = new StringBuilder();
                for (textNote n : notes) {
                    builder.append("Title: ").append(n.getTitle()).append("\n")
                            .append("Body: ").append(n.getTextContent()).append("\n\n");
                }
                ShowNoteFromAPI.setText(builder.toString());
            }
            @Override
            public void onFailure(Call<List<textNote>> call, Throwable t) {
                ShowNoteFromAPI.setText("Failed; " + t.getMessage());
            }
        });


    }
}