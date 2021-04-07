package com.example.malclient.ui.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


import com.example.malclient.R;
import com.example.malclient.models.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityList extends Activity {

    ListView listview;
    Button Addbutton;
    EditText GetValue;
    String[] ListElements = new String[] {
            "Anime",
            "Type"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        Addbutton = (Button) findViewById(R.id.button1);
        GetValue = (EditText) findViewById(R.id.editText1);
       Bundle bundle= getIntent().getExtras();
        if (bundle != null){
            Anime anime = bundle.getParcelable("anime");
            Addbutton.setText(anime.getTitle());
        }
        //TODO Cambiar este activity y su layout para que se vea mejor
    }
}