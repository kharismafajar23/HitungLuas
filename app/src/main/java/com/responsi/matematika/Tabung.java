package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Tabung extends AppCompatActivity {

    ImageView btnBack9;
    EditText etJarialas, etTinggiTabung;
    Button btnHitung9;
    TextView tvHasil9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tabung);

        btnBack9 = findViewById(R.id.btnBack9);
        etJarialas = findViewById(R.id.etJariJariAlas);
        etTinggiTabung = findViewById(R.id.etTinggiTabung);
        btnHitung9 = findViewById(R.id.btnHitung9);
        tvHasil9 = findViewById(R.id.tvHasilTabung);

        //menghitung volume tabung
        btnHitung9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double jari_jari, tinggi, hasil;
                jari_jari = Double.valueOf(etJarialas.getText().toString().trim());
                tinggi = Double.valueOf(etTinggiTabung.getText().toString().trim());
                hasil = 3.14 * jari_jari * jari_jari * tinggi;
                String volumeTabung = String.valueOf(hasil);
                tvHasil9.setText(volumeTabung);

            }
        });

        //kembali
        btnBack9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}