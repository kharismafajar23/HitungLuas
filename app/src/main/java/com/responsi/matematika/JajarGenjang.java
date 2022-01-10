package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class JajarGenjang extends AppCompatActivity {

    ImageView btnBack8;
    EditText etAlas8, etTinggi8;
    Button btnHitung8;
    TextView tvHasil8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jajar_genjang);

        btnBack8 = findViewById(R.id.btnBack8);
        etAlas8 = findViewById(R.id.etAlas8);
        etTinggi8 = findViewById(R.id.etTinggi8);
        btnHitung8 = findViewById(R.id.btnHitung8);
        tvHasil8 = findViewById(R.id.tvHasilJajarGenjang);

        //hitung luas persegi panjang
        btnHitung8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double alas8, tinggi8, hasil;
                alas8 = Double.valueOf(etAlas8.getText().toString().trim());
                tinggi8 = Double.valueOf(etTinggi8.getText().toString().trim());

                hasil = alas8 * tinggi8;
                String luasjajarGenjang = String.valueOf(hasil);
                tvHasil8.setText(luasjajarGenjang);
            }
        });

        //kembali
        btnBack8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}