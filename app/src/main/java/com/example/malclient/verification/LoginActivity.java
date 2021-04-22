package com.example.malclient.verification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.malclient.MainActivity;
import com.example.malclient.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText emailET, passwordET;
    FirebaseAuth firebaseAuth;
    MaterialButton logIn_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.email_editText);
        passwordET = findViewById(R.id.password_editText);
        logIn_button = findViewById(R.id.login_button);
        autetification();

        logIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigInUser();
            }
        });
    }

    private void autetification() {
        firebaseAuth = FirebaseAuth.getInstance();

    }




    private void sigInUser(){
        try {
            if (!emailET.getText().toString().isEmpty() && !passwordET.getText().toString().isEmpty()){
                if (firebaseAuth!=null){
                    firebaseAuth.signInWithEmailAndPassword(emailET.getText().toString(),passwordET.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            else Toast.makeText(this,"Please fill the fields",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}