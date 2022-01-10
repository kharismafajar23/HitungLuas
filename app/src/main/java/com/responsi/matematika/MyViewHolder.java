package com.responsi.matematika;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

    TextView judul;
    ImageView btnDownload;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        judul = itemView.findViewById(R.id.judul);
        btnDownload = itemView.findViewById(R.id.btnDownload);

    }
}
