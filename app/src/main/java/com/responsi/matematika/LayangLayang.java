package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LayangLayang extends AppCompatActivity {

    ImageView btnBack6;
    EditText etDiagonal1a, etDiagonal2a;
    Button btnHitung6;
    TextView tvHasil6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_layang_layang);

        btnBack6 = findViewById(R.id.btnBack6);
        etDiagonal1a = findViewById(R.id.etDiagonal1a);
        etDiagonal2a = findViewById(R.id.etDiagonal2a);
        btnHitung6 = findViewById(R.id.btnHitung6);
        tvHasil6 = findViewById(R.id.tvHasilLayangLayang);

        //hitung luas layang layang
        btnHitung6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double diagonal1a, diagonal2a, hasil;
                diagonal1a = Double.valueOf(etDiagonal1a.getText().toString().trim());
                diagonal2a = Double.valueOf(etDiagonal2a.getText().toString().trim());

                hasil = (diagonal1a*diagonal2a) / 2;
                String luasLayang = String.valueOf(hasil);
                tvHasil6.setText(luasLayang);
            }
        });

        //kembali
        btnBack6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}