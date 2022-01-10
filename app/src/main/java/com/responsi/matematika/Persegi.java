package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Persegi extends AppCompatActivity {

    ImageView btnBack1;
    EditText etSisi1;
    Button btnHasilPersegi;
    TextView tvHasilPersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_persegi);

        btnBack1 = findViewById(R.id.btnBack1);
        etSisi1 = findViewById(R.id.etSisi1);
        btnHasilPersegi = findViewById(R.id.btnHitungPersegi);
        tvHasilPersegi = findViewById(R.id.tvHasilPersegi);

        btnHasilPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sisi, hasil;
                sisi = Double.valueOf(etSisi1.getText().toString().trim());
                hasil = sisi*sisi;
                String luasPersegi = String.valueOf(hasil);
                tvHasilPersegi.setText(luasPersegi);

            }
        });

        //kembali
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}