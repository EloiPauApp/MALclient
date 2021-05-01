package com.example.malclient.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.malclient.LaunchActivity;
import com.example.malclient.MainActivity;
import com.example.malclient.R;
import com.example.malclient.verification.RegisterActivity;
import com.google.firebase.auth.FirebaseAuth;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {


    private Button button;
    private static final int RC_SIGN_IN = 123;
    FirebaseAuth firebaseAuth;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView = root.findViewById(R.id.text_home);
        firebaseAuth = FirebaseAuth.getInstance();
        button = root.findViewById(R.id.boton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);

            }
        });

        if (firebaseAuth.getCurrentUser() !=null){
            String currentUser = firebaseAuth.getCurrentUser().getEmail();
            textView.setText("Welcome "+currentUser);
            button.setVisibility(View.INVISIBLE);
        }else button.setVisibility(View.VISIBLE);

        return root;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RC_SIGN_IN) {
//
//        }
//    }
}