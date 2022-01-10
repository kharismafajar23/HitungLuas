package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Trapesium extends AppCompatActivity {

    ImageView btnBack7;
    EditText etPanjangA, etPanjangB, etTinggi7;
    Button btnHitung7;
    TextView tvHasil7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trapesium);

        btnBack7 = findViewById(R.id.btnBack7);
        etPanjangA = findViewById(R.id.etPanjangA);
        etPanjangB = findViewById(R.id.etPanjangB);
        etTinggi7 = findViewById(R.id.etTinggi7);
        btnHitung7 = findViewById(R.id.btnHitung7);
        tvHasil7 = findViewById(R.id.tvHasilTrapesium);

        //hitung luas trapesium
        btnHitung7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double panjangA, panjangB, tinggi, hasil;
                panjangA = Double.valueOf(etPanjangA.getText().toString().trim());
                panjangB = Double.valueOf(etPanjangB.getText().toString().trim());
                tinggi = Double.valueOf(etTinggi7.getText().toString().trim());

                hasil = ((panjangA + panjangB)/2)*tinggi;
                String luasTrapesium = String.valueOf(hasil);
                tvHasil7.setText(luasTrapesium);
            }
        });

        //kembali
        btnBack7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}