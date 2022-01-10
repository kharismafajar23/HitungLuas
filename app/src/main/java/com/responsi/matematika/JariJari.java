package com.responsi.matematika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class JariJari extends AppCompatActivity {

    ImageView btnBack10;
    EditText etDiameter10;
    Button btnHitung10;
    TextView tvHasil10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jari_jari);

        btnBack10 = findViewById(R.id.btnBack10);
        etDiameter10 = findViewById(R.id.etDiameter10);
        btnHitung10 = findViewById(R.id.btnHitung10);
        tvHasil10 = findViewById(R.id.tvHasilJari);

        //menghitung luas lingkaran
        btnHitung10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double diameter, hasil;
                diameter = Double.valueOf(etDiameter10.getText().toString().trim());
                hasil = diameter / 2;
                String jariJariLingkaran = String.valueOf(hasil);
                tvHasil10.setText(jariJariLingkaran);

            }
        });

        //kembali
        btnBack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}