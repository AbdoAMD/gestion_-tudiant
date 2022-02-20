package com.example.gestionetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText Name, Password;
    Button bt;
    TextView txtV;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt = findViewById(R.id.btnLogin);
        Name = findViewById(R.id.etName);
        Password = findViewById(R.id.etPassword);
        txtV = findViewById(R.id.txtInfo);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View view ) {
                bnLogin(Name.getText().toString(), Password.getText().toString());
            }
        });
    }


    private void bnLogin ( String Name, String Password ) {
        if ((Name.equals("kadim")) && (Password.equals("1234"))) {
            Intent intent = new Intent(LoginActivity.this, Menu.class);
            startActivity(intent);
        } else if (Name != "kadim" || Password != "1234") {
            //Toast.makeText(LoginActivity.this, "votre Name et password n'est pas correct", Toast.LENGTH_SHORT).show();

            txtV.setText("votre Name ou password n'est pas correct");

        }
    }
}