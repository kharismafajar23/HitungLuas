package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PersegiPanjang extends AppCompatActivity {

    ImageView btnBack2;
    EditText etPanjang2, etLebar2;
    Button btnHitung2;
    TextView tvHasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_persegi_panjang);

        btnBack2 = findViewById(R.id.btnBack2);
        etPanjang2 = findViewById(R.id.etPanjang2);
        etLebar2 = findViewById(R.id.etLebar2);
        btnHitung2 = findViewById(R.id.btnHitungPersegiPanjang);
        tvHasil2 = findViewById(R.id.tvHasilPersegipanjang);

        //hitung luas persegi panjang
        btnHitung2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double panjang2, lebar2, hasil;
                panjang2 = Double.valueOf(etPanjang2.getText().toString().trim());
                lebar2 = Double.valueOf(etLebar2.getText().toString().trim());

                hasil = panjang2 * lebar2;
                String luasPersegiPanjang = String.valueOf(hasil);
                tvHasil2.setText(luasPersegiPanjang);
            }
        });

        //kembali
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}