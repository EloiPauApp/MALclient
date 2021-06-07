package com.example.malclient.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malclient.MainActivity;
import com.example.malclient.R;
import com.example.malclient.adapter.AdapterAnime;
import com.example.malclient.models.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.malclient.ui.list.ListViewModel.animes;

public class ListFragment extends Fragment {


    private ListViewModel listViewModel;
    private Button addBtn;
    private RecyclerView animeList;
    EditText title;

    EditText getValue;
    String[] ListElements = new String[] {
            "Anime",
            "Type"
    };
    AdapterAnime adapterAnime;


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);

    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        addBtn = root.findViewById(R.id.addBtn);
        animeList = root.findViewById(R.id.listAnime);

        adapterAnime = new AdapterAnime(animes);
        animeList.setAdapter(adapterAnime);
        animeList.setLayoutManager(new LinearLayoutManager(getContext()));

        addBtn.setOnClickListener(v -> {
            Anime anime = new Anime();
            anime.setTitle("One Piece");
            anime.setScore(10);
            animes.add(anime);
            adapterAnime.setAnimes(animes);
        });

        listViewModel.getText().observe(getViewLifecycleOwner(), s -> {
        });
        return root;
    }
}