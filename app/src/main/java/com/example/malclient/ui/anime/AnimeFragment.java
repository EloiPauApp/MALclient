package com.example.malclient.ui.anime;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.malclient.R;
import com.example.malclient.models.Anime;

public class AnimeFragment extends Fragment {


    private final AnimeViewModel animeViewModel;
    EditText editar_nota;
    Spinner estat;
    TextView nota, title, afegir_estat;
    ImageView image_url;
    Button addButton;
    Anime animeModel;
    int animePosition = -1;

    public AnimeFragment(AnimeViewModel animeViewModel) {
        this.animeViewModel = animeViewModel;
    }

    public AnimeFragment() {

        animeViewModel = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_anime, container, false);

        afegir_estat = v.findViewById(R.id.afegir_estat);
        estat = v.findViewById(R.id.spinner_estat);
        nota = v.findViewById(R.id.nota);
        editar_nota = v.findViewById(R.id.editar_nota);
        addButton = v.findViewById(R.id.addBtn);

        nota.setVisibility(View.INVISIBLE);
        editar_nota.setVisibility(View.INVISIBLE);
        addButton.setText("Add");

        estat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2){
                    editar_nota.setVisibility(View.VISIBLE);
                    nota.setVisibility(View.VISIBLE);
                }else{
                    editar_nota.setVisibility(View.INVISIBLE);
                    nota.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(getArguments() != null){
            animePosition = getArguments().getInt("animeModel");
            if(animePosition > -1){
                addButton.setText("Amunt");
                animeModel = AnimeViewModel.animeregister.get(animePosition);
                title.setText(animeModel.getTitle());
                estat.setSelection(animeModel.getEstat());
                if(animeModel.getNota() != 6)editar_nota.setText(String.valueOf(animeModel.getNota()));
            }
        }

        addButton.setOnClickListener(v2 -> {
            if(!title.getText().toString().equals("") && !image_url.getDrawable().toString().equals("")) {
                animeModel = new Anime(title.getText().toString(), image_url.getDrawable().toString(), estat.getSelectedItem().toString(), estat.getSelectedItemPosition(), 6);
                if(editar_nota.getVisibility() == View.VISIBLE){
                    if(!editar_nota.getText().toString().equals("")) {
                        try {
                            int nota = Integer.parseInt(editar_nota.getText().toString());
                            if(nota >= 0 && nota <= 5){
                                animeModel.setNota(nota);
                                addAnime(v);
                            }else Toast.makeText(getContext(), "Nota entre 1 i 10", Toast.LENGTH_SHORT).show();
                        } catch (NumberFormatException e) {
                            Toast.makeText(getContext(), "Nota ha de ser un numero", Toast.LENGTH_SHORT).show();
                        }
                    }else Toast.makeText(getContext(), "Falta omplir algun camp", Toast.LENGTH_SHORT).show();
                }else{
                    addAnime(v);
                }
            }else Toast.makeText(getContext(), "Falta omplir algun camp", Toast.LENGTH_SHORT).show();
        });
        return v;
    }

    public void addAnime(View v){
        if(animePosition < 0){
            AnimeViewModel.animeregister.add(animeModel);
        }else {
            AnimeViewModel.animeregister.get(animePosition).setTitle(animeModel.getTitle());
            AnimeViewModel.animeregister.get(animePosition).setImage_url(animeModel.getImage_url());
            AnimeViewModel.animeregister.get(animePosition).getEstat();
            AnimeViewModel.animeregister.get(animePosition).setNota(animeModel.getNota());
        }
    }

}