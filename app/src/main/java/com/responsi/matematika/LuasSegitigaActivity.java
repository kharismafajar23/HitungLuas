package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LuasSegitigaActivity extends AppCompatActivity {

    EditText etAlas4, etTinggi4;
    Button btnHitungSegitiga;
    TextView tvHasil4;
    ImageView btnBack4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_luas_segitiga);

        etAlas4 = findViewById(R.id.etAlas);
        etTinggi4 = findViewById(R.id.etTinggi);
        btnHitungSegitiga = findViewById(R.id.btnHitungSegitiga);
        tvHasil4 = findViewById(R.id.tvHasilSegitiga);
        btnBack4 = findViewById(R.id.btnBack4);

        //hitung luas segitiga
        btnHitungSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double alas4, tinggi4, hasil;
                alas4 = Double.valueOf(etAlas4.getText().toString().trim());
                tinggi4 = Double.valueOf(etTinggi4.getText().toString().trim());

                hasil = (alas4*tinggi4) / 2;
                String luasSegitiga = String.valueOf(hasil);
                tvHasil4.setText(luasSegitiga);
            }
        });

        //kembali
        btnBack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}