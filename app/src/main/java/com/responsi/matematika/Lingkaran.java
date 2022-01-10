package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Lingkaran extends AppCompatActivity {

    ImageView btnBack3;
    EditText etJarijari3;
    Button btnHitung3;
    TextView tvHasilLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lingkaran);

        btnBack3 = findViewById(R.id.btnBack3);
        etJarijari3 = findViewById(R.id.etJariJari3);
        btnHitung3 = findViewById(R.id.btnHitung3);
        tvHasilLingkaran = findViewById(R.id.tvHasilLingkaran);

        //menghitung luas lingkaran
        btnHitung3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double jari_jari, hasil;
                jari_jari = Double.valueOf(etJarijari3.getText().toString().trim());
                hasil = 3.14 * jari_jari * jari_jari;
                String luasLingkaran = String.valueOf(hasil);
                tvHasilLingkaran.setText(luasLingkaran);

            }
        });

        //kembali
        btnBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}