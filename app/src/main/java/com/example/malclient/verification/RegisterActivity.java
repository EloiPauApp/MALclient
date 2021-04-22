package com.example.malclient.verification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.malclient.MainActivity;
import com.example.malclient.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout username, password, fpassword, correu, nom, cognom, aniversari, genere;
    CheckBox checkBox;
    Button register, login;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username_register);
        password = findViewById(R.id.password_register);
        fpassword = findViewById(R.id.password_register2);
        correu = findViewById(R.id.email);
        nom = findViewById(R.id.name);
        cognom = findViewById(R.id.surname);
        aniversari = findViewById(R.id.birth_date);
        genere = findViewById(R.id.gender_pronoum);
        checkBox = findViewById(R.id.contract);
        register = findViewById(R.id.register_signin);
        login = findViewById(R.id.login_signin);
        autetification();

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        final  MaterialDatePicker<Long> picker = builder.build();

        picker.addOnPositiveButtonClickListener(selection -> aniversari.getEditText().setText(picker.getHeaderText()));

        aniversari.getEditText().setOnClickListener(v -> picker.show(getSupportFragmentManager(), picker.toString()));

        register.setOnClickListener(v -> {
            username.setErrorEnabled(false);
            password.setErrorEnabled(false);
            fpassword.setErrorEnabled(false);
            correu.setErrorEnabled(false);
            nom.setErrorEnabled(false);
            cognom.setErrorEnabled(false);
            aniversari.setErrorEnabled(false);
            genere.setErrorEnabled(false);
            boolean allRight = true;

//            if(username.getEditText().getText().toString().equals("")){
//                username.setError("Camp obligatori");
//                allRight = false;
//            }

            if(!password.getEditText().getText().toString().equals("")){
                if(password.getEditText().getText().length() < 7) {
                    password.setError("Contrasenya curta");
                    allRight = false;
                }
            } else {
                allRight = false;
                password.setError("Camp obligatori");
            }

//            if(!fpassword.getEditText().getText().toString().equals("")){
//                if(!fpassword.getEditText().getText().toString().equals(password.getEditText().getText().toString())){
//                    System.out.println("passa per aqui\n"+fpassword.getEditText().getText()+"\n"+password.getEditText().getText());
//                    fpassword.setError("Les contrasenyes no coincideixen");
//                    allRight = false;
//                }
//            } else {
//                allRight = false;
//                fpassword.setError("Camp obligatori");
//            }

            if(correu.getEditText().getText().toString().equals("")){
                correu.setError("Camp obligatori");
                allRight = false;
            }

//            if(nom.getEditText().getText().toString().equals("")){
//                nom.setError("Camp obligatori");
//                allRight = false;
//            }
//
//            if(cognom.getEditText().getText().toString().equals("")){
//                cognom.setError("Camp obligatori");
//                allRight = false;
//            }
//
//            if(aniversari.getEditText().getText().toString().equals("")){
//                aniversari.setError("Camp obligatori");
//                allRight = false;
//            }
//
//            if(genere.getEditText().getText().toString().equals("")){
//                genere.setError("Camp obligatori");
//                allRight = false;
//            }
//
//            if(!checkBox.isChecked()) Toast.makeText(RegisterActivity.this,"You must accept the Terms",Toast.LENGTH_SHORT).show();

            if(allRight && checkBox.isChecked()){
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
//                startActivity(i);
//                finish();
                checkUserExist();
            }
        });
        login.setOnClickListener(v -> {
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });
    }

    private void autetification() {
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void createUser(){
        try {
            if (!correu.getEditText().getText().toString().isEmpty() && !password.getEditText().getText().toString().isEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(correu.getEditText().getText().toString(),password.getEditText().getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(RegisterActivity.this,"User created",Toast.LENGTH_SHORT).show();
                        correu.getEditText().setText("");
                        password.getEditText().setText("");
                        if (firebaseAuth.getCurrentUser() != null){
                            //TODO Continuar con la autentificación
                            firebaseAuth.signOut();
                            Toast.makeText(RegisterActivity.this,"User deleted",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }else Toast.makeText(this,"Please fill the fields",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void checkUserExist(){
        try {
            if (firebaseAuth!=null && !correu.getEditText().getText().toString().isEmpty()){
                firebaseAuth.fetchSignInMethodsForEmail(correu.getEditText().getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                            @Override
                            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                                boolean checkResult= !task.getResult().getSignInMethods().isEmpty();

                                if (!checkResult){
                                    createUser();
                                }
                                else Toast.makeText(RegisterActivity.this,"User already been created",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
