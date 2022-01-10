package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BelahKetupat extends AppCompatActivity {

    EditText etDiagonal1, etDiagonal2;
    Button btnHitung5;
    TextView tvHasil5;
    ImageView btnBack5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_belah_ketupat);

        btnBack5 = findViewById(R.id.btnBack5);
        etDiagonal1 = findViewById(R.id.etDiagonal1);
        etDiagonal2 = findViewById(R.id.etDiagonal2);
        btnHitung5 = findViewById(R.id.btnHitung5);
        tvHasil5 = findViewById(R.id.tvHasilBelahKetupat);

        //hitung luas belah ketupat
        btnHitung5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double diagonal1, diagonal2, hasil;
                diagonal1 = Double.valueOf(etDiagonal1.getText().toString().trim());
                diagonal2 = Double.valueOf(etDiagonal2.getText().toString().trim());

                hasil = (diagonal1*diagonal2) / 2;
                String luasBelahKetupat = String.valueOf(hasil);
                tvHasil5.setText(luasBelahKetupat);
            }
        });

        //kembali
        btnBack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}