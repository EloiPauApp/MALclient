package com.example.malclient.verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.malclient.MainActivity;
import com.example.malclient.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout username, password, fpassword, correu, nom, cognom, aniversari, genere;
    CheckBox checkBox;
    Button register, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        checkBox = findViewById(R.id.accelerate);
        register = findViewById(R.id.register_signin);
        login = findViewById(R.id.login_signin);

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        final  MaterialDatePicker<Long> picker = builder.build();

        picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                aniversari.getEditText().setText(picker.getHeaderText());
            }
        });

        aniversari.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.show(getSupportFragmentManager(), picker.toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setErrorEnabled(false);
                password.setErrorEnabled(false);
                fpassword.setErrorEnabled(false);
                correu.setErrorEnabled(false);
                nom.setErrorEnabled(false);
                cognom.setErrorEnabled(false);
                aniversari.setErrorEnabled(false);
                genere.setErrorEnabled(false);;
                boolean allRight = true;

                if(username.getEditText().getText().toString().equals("")){
                    username.setError("Camp obligatori");
                    allRight = false;
                }

                if(!password.getEditText().getText().toString().equals("")){
                    if(password.getEditText().getText().length() < 7) {
                        password.setError("Contrasenya curta");
                        allRight = false;
                    }
                } else {
                    allRight = false;
                    password.setError("Camp obligatori");
                }

                if(!fpassword.getEditText().getText().toString().equals("")){
                    if(!fpassword.getEditText().getText().toString().equals(password.getEditText().getText().toString())){
                        System.out.println("passa per aqui\n"+fpassword.getEditText().getText()+"\n"+password.getEditText().getText());
                        fpassword.setError("Les contrasenyes no coincideixen");
                        allRight = false;
                    }
                } else {
                    allRight = false;
                    fpassword.setError("Camp obligatori");
                }

                if(correu.getEditText().getText().toString().equals("")){
                    correu.setError("Camp obligatori");
                    allRight = false;
                }

                if(nom.getEditText().getText().toString().equals("")){
                    nom.setError("Camp obligatori");
                    allRight = false;
                }

                if(cognom.getEditText().getText().toString().equals("")){
                    cognom.setError("Camp obligatori");
                    allRight = false;
                }

                if(aniversari.getEditText().getText().toString().equals("")){
                    aniversari.setError("Camp obligatori");
                    allRight = false;
                }

                if(genere.getEditText().getText().toString().equals("")){
                    genere.setError("Camp obligatori");
                    allRight = false;
                }

//                if(checkBox.isChecked()) Toast.makeText(RegisterActivity.this,"You must accept the Terms",Toast.LENGTH_SHORT).show();

                if(allRight && checkBox.isChecked()){
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
