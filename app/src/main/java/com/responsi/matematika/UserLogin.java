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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserLogin extends AppCompatActivity {

    ImageView btnBack12;
    EditText etUsername2, etPassword2;
    Button btnMasuk2;
    TextView tvDaftar;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_login);

        btnBack12 = findViewById(R.id.btnBack12);
        etUsername2 = findViewById(R.id.etUsername2);
        etPassword2 = findViewById(R.id.etPassword2);
        btnMasuk2 = findViewById(R.id.btnMasuk2);
        tvDaftar = findViewById(R.id.tvDaftar);

        //saat button masuk di klik
        btnMasuk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername2.getText().toString();
                String password = etPassword2.getText().toString();

                reference = FirebaseDatabase.getInstance().getReference().child("User").child(username);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            //ambil password
                            String passwordFromFirebase = dataSnapshot.child("password").getValue().toString();
                            //validasi password
                            if (password.equals(passwordFromFirebase)) {

                                //simpan username ke lokal
                                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(username_key, etUsername2.getText().toString());
                                editor.apply();

                                //berpindah ke home
                                Intent keHome = new Intent(UserLogin.this, MainActivity.class);
                                startActivity(keHome);

                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Username tidak ada", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        //ketika tulisan daftar di klik
        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keUserDaftar = new Intent(UserLogin.this, UserSignup.class);
                startActivity(keUserDaftar);
            }
        });

        //kembali
        btnBack12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}