package com.responsi.matematika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView tvNama;
    LinearLayout persegi, persegiPanjang, lingkaran, segitiga, belahKetupat, layangLayang, trapesium, jajarGenjang, tabung, jariJari;
    Button baca;
    ImageView btnSignOut2;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getUsernameLocal();

        tvNama = findViewById(R.id.tvNama);
        persegi = findViewById(R.id.persegi);
        persegiPanjang = findViewById(R.id.persegiPanjang);
        lingkaran = findViewById(R.id.lingkaran);
        segitiga = findViewById(R.id.segitiga);
        belahKetupat = findViewById(R.id.belahKetupat);
        layangLayang = findViewById(R.id.layangLayang);
        trapesium = findViewById(R.id.trapesium);
        jajarGenjang = findViewById(R.id.jajarGenjang);
        tabung = findViewById(R.id.tabung);
        jariJari = findViewById(R.id.jariJari);
        baca = findViewById(R.id.btnBaca);
        btnSignOut2 = findViewById(R.id.btnSignOut2);

        reference = FirebaseDatabase.getInstance().getReference().child("User").child(username_key_new);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tvNama.setText(dataSnapshot.child("username").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //ke persegi
        persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kePersegi = new Intent(MainActivity.this, Persegi.class);
                startActivity(kePersegi);
            }
        });

        //ke persegi panjang
        persegiPanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kePersegiPanjang = new Intent(MainActivity.this, PersegiPanjang.class);
                startActivity(kePersegiPanjang);
            }
        });

        //ke lingkaran
        lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keLingkaran = new Intent(MainActivity.this, Lingkaran.class);
                startActivity(keLingkaran);
            }
        });

        //ke segitiga
        segitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keSegitiga = new Intent(MainActivity.this, LuasSegitigaActivity.class);
                startActivity(keSegitiga);
            }
        });

        //ke belah ketupat
        belahKetupat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keBelahKetupat = new Intent(MainActivity.this, BelahKetupat.class);
                startActivity(keBelahKetupat);
            }
        });

        //ke layang layang
        layangLayang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keLayang = new Intent(MainActivity.this, LayangLayang.class);
                startActivity(keLayang);
            }
        });

        //ke trapesium
        trapesium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keTrapesium = new Intent(MainActivity.this, Trapesium.class);
                startActivity(keTrapesium);
            }
        });

        //ke jajar genjang
        jajarGenjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keJajar = new Intent(MainActivity.this, JajarGenjang.class);
                startActivity(keJajar);
            }
        });

        //ke tabung
        tabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keTabung = new Intent(MainActivity.this, Tabung.class);
                startActivity(keTabung);
            }
        });

        //ke jari jari
        jariJari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keJari = new Intent(MainActivity.this, JariJari.class);
                startActivity(keJari);
            }
        });

        //ke baca materi
        baca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keBaca = new Intent(MainActivity.this, LihatMateri.class);
                startActivity(keBaca);
            }
        });

        //sign out
        btnSignOut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keUserLogin = new Intent(MainActivity.this, UserLogin.class);
                startActivity(keUserLogin);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // or finish();
    }

    public  void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key,"");
    }
}