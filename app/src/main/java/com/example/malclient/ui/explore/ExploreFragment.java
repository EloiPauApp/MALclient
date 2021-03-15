package com.example.malclient.ui.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malclient.APIresources.MyAnimeListAPI;
import com.example.malclient.R;
import com.example.malclient.models.Data;
import com.example.malclient.webService.WebServiceClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExploreFragment extends Fragment {

    private ExploreViewModel exploreViewModel;

    EditText seacrhEditText;
    RecyclerView rvSearch;
    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_explore, container, false);
        seacrhEditText = root.findViewById(R.id.search_edit_text);
        String name= null;
        lanzarPeticion(name);
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
    }
}