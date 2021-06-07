package com.example.malclient.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.malclient.models.Anime;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    public static List animes = new ArrayList<Anime>();

    private MutableLiveData<String> mText;

    public ListViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}