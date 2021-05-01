package com.example.malclient.ui.anime;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.malclient.MainActivity;
import com.example.malclient.R;
import com.example.malclient.models.Anime;
import com.example.malclient.ui.list.ListView;
import com.example.malclient.verification.LoginActivity;
import com.example.malclient.verification.RegisterActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AnimeActivity extends AppCompatActivity {

    TextInputEditText add_title, edit_score;
    TextInputLayout title, score;
    MaterialButton addButton;
    Anime animeModel;
    Spinner estats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        title = findViewById(R.id.title);
        add_title=findViewById(R.id.add_title);
        score=findViewById(R.id.score);
        edit_score=findViewById(R.id.edit_score);
        addButton=findViewById(R.id.addAnime);
        estats=findViewById(R.id.estats);

        addButton.setOnClickListener(v -> {

            Intent i = new Intent(com.example.malclient.ui.anime.AnimeActivity.this, MainActivity.class);
            startActivity(i);
        });
    }
}
