package com.responsi.matematika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserSignup extends AppCompatActivity {

    ImageView btnBack13;
    EditText etUsername3, etEmail3, etPassword3, etNoHandphone3;
    Button btnDaftar3;
    TextView tvMasuk3;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_signup);

        btnBack13 = findViewById(R.id.btnBack13);
        etUsername3 = findViewById(R.id.etUsername3);
        etEmail3 = findViewById(R.id.etEmail3);
        etPassword3 = findViewById(R.id.etPassword3);
        etNoHandphone3 = findViewById(R.id.etNoHandphone3);
        btnDaftar3 = findViewById(R.id.btnDaftar3);
        tvMasuk3 = findViewById(R.id.tvMasuk3);

        //ketika button daftar di klik
        btnDaftar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan data ke lokal
                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(username_key, etUsername3.getText().toString());
                editor.apply();

                //simpan ke database
                reference = FirebaseDatabase.getInstance().getReference().child("User").child(etUsername3.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("username").setValue(etUsername3.getText().toString());
                        dataSnapshot.getRef().child("email").setValue(etEmail3.getText().toString());
                        dataSnapshot.getRef().child("password").setValue(etPassword3.getText().toString());
                        dataSnapshot.getRef().child("no_handphone").setValue(etNoHandphone3.getText().toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Intent keHome = new Intent(UserSignup.this, MainActivity.class);
                startActivity(keHome);
            }
        });




        //ketika teks masuk di klik
        tvMasuk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keMasukUser = new Intent(UserSignup.this, UserLogin.class);
                startActivity(keMasukUser);
            }
        });

        //kembali
        btnBack13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}