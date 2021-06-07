package com.example.malclient.ui.anime;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.malclient.R;
import com.example.malclient.adapter.AdapterAnime;
import com.example.malclient.models.Anime;
import com.example.malclient.ui.list.ListFragment;
import com.example.malclient.ui.list.ListView;
import com.example.malclient.ui.list.ListViewModel;
import com.example.malclient.verification.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.malclient.ui.list.ListViewModel.animes;

public class AnimeDetailActivity extends AppCompatActivity {

    private static final String TAG = "Botó";
    ImageView imageView;
    TextView tituloTextView, capitulosTextView, statusTextView, synopsisTextView;
    Anime anime;
    FloatingActionButton addBtn;
    private Context context;
    ListViewModel listViewModel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_details);
        tituloTextView = findViewById(R.id.button1);
        imageView = findViewById(R.id.anime_imageView);
        capitulosTextView = findViewById(R.id.capitulos_TextView);
        statusTextView = findViewById(R.id.status_TextView);
        synopsisTextView = findViewById(R.id.synopsis_TextView);
        addBtn=findViewById(R.id.floatingActionButton);

       Bundle bundle= getIntent().getExtras();
        if (bundle != null){
            anime = bundle.getParcelable("anime");
            tituloTextView.setText(anime.getTitle());
            Picasso.with(this).load(anime.getImage_url()).into(imageView);
            capitulosTextView.setText(anime.getEpisodes()+" Episodes");
            System.out.println(anime);
            if (!anime.isAiring()) statusTextView.setText("Status: Not Airing");
            synopsisTextView.setText(anime.getSynopsis());

        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animes.add(anime);
                finish();
            }
        });

    }


}