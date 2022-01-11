package com.responsi.matematika;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AdminDashboard extends AppCompatActivity {

    TextView tvNamaAdmin;
    ImageView btnSignOut1;
    Button btnUploadDisini;
    ListView listDaftarMateri;
    List<AmbilMateri> materi;

    DatabaseReference reference;


    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin_dashboard);

        getUsernameLocal();
        tvNamaAdmin = findViewById(R.id.tvNamaAdmin);
        btnSignOut1 = findViewById(R.id.btnSignout1);
        btnUploadDisini = findViewById(R.id.btnUploadDisini);
        listDaftarMateri = findViewById(R.id.listDaftarMateri);
        
        materi = new ArrayList<>();
        lihatMateri();

        reference = FirebaseDatabase.getInstance().getReference().child("Admin").child(username_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tvNamaAdmin.setText(dataSnapshot.child("username").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //ke user login
        btnSignOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keUserLogin = new Intent(AdminDashboard.this, AdminLogin.class);
                startActivity(keUserLogin);
            }
        });

        //ke upload
        btnUploadDisini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keUpload = new Intent(AdminDashboard.this, UploadMateri.class);
                startActivity(keUpload);
            }
        });

        //saat daftar materi di klik
        listDaftarMateri.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AmbilMateri ambilMateri = materi.get(i);

                Intent bacaMateri = new Intent(Intent.ACTION_VIEW);
                bacaMateri.setType("application/pdf");
                bacaMateri.setData(Uri.parse(ambilMateri.getUrl()));
                startActivity(bacaMateri);
            }
        });
    }

    private void lihatMateri() {
        reference = FirebaseDatabase.getInstance().getReference("Materi");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    AmbilMateri ambilMateri = ds.getValue(AmbilMateri.class);
                    materi.add(ambilMateri);
                }
                String[] daftarMateri = new String[materi.size()];
                for (int i = 0; i < daftarMateri.length; i++) {
                    daftarMateri[i] = materi.get(i).getJudul();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, daftarMateri){

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView textView = (TextView) view.findViewById(android.R.id.text1);
                        return view;
                    }
                };
                listDaftarMateri.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity(); // or finish();
    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key,"");
    }
}