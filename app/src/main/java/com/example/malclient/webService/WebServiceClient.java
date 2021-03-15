package com.example.malclient.webService;

import com.example.malclient.APIresources.MyAnimeListAPI;
import com.example.malclient.models.Anime;
import com.example.malclient.models.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebServiceClient {
    @GET()
    Call<Data> getAnimes(@Url String url);

    @GET()
    Call<Anime> getAnime(@Url String url);

}
