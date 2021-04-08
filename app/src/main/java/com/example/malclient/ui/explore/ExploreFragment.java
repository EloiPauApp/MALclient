package com.example.malclient.ui.explore;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malclient.APIresources.MyAnimeListAPI;
import com.example.malclient.R;
import com.example.malclient.adapter.AdapterAnime;
import com.example.malclient.models.Anime;
import com.example.malclient.models.Data;
import com.example.malclient.webService.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExploreFragment extends Fragment {

    private ExploreViewModel exploreViewModel;

    EditText seacrhEditText;
    RecyclerView rvSearch;
    AdapterAnime adapterAnime;

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_explore, container, false);
        seacrhEditText = root.findViewById(R.id.search_edit_text);
        rvSearch = root.findViewById(R.id.rvSeacrh);
        List animes = new ArrayList<Anime>();
        adapterAnime = new AdapterAnime(animes);
        rvSearch.setAdapter(adapterAnime);
        rvSearch.setLayoutManager(new GridLayoutManager(getContext(),3));
        String name= null;
        lanzarPeticion(name);

        seacrhEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode==66 && seacrhEditText.getText().toString().length()>=3){
                    lanzarPeticion(seacrhEditText.getText().toString());
                }else lanzarPeticion(name);
                return false;
            }
        });
        return root;
    }

    private void lanzarPeticion(String name) {
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder().baseUrl(MyAnimeListAPI.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build()).build();

        //TODO probar Retrofit
        WebServiceClient client = retrofit.create(WebServiceClient.class);
        Call<Data> call;

        if (name == null){
            call = client.getAnimes(MyAnimeListAPI.PUT_TOP);
        }else {
            call = client.getAnimes(MyAnimeListAPI.PUT_NAME+name);
        }

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (name!=null)adapterAnime.setAnimes(response.body().getResults());
                else adapterAnime.setAnimes(response.body().getTop());

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG1", "Error: " + t.getMessage());
            }
        });
    }
}