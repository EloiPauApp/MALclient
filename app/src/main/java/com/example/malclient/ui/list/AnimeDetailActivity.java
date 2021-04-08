package com.example.malclient.ui.list;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.malclient.R;
import com.example.malclient.models.Anime;
import com.squareup.picasso.Picasso;

public class AnimeDetailActivity extends Activity {

    ImageView imageView;
    TextView tituloTextView, capitulosTextView, statusTextView, synopsisTextView;
    Anime anime;

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
        //TODO Cambiar este activity y su layout para que se vea mejor
    }
}