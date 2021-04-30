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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        addBtn = root.findViewById(R.id.addBtn);
        getValue = root.findViewById(R.id.titol);
        animeList = root.findViewById(R.id.listAnime);
        title=root.findViewById(R.id.afegir_titol);

        List animes = new ArrayList<Anime>();
        adapterAnime = new AdapterAnime(animes);
        animeList.setAdapter(adapterAnime);
        animeList.setLayoutManager(new LinearLayoutManager(getContext()));


//        final List< String > ListElementsArrayList = new ArrayList< String >
//                (Arrays.asList(ListElements));
//
//
//        final ArrayAdapter< String > adapter = new ArrayAdapter < String >
//                (getContext(), android.R.layout.simple_list_item_1,
//                        ListElementsArrayList);

//        animeList.setAdapter(adapter);

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