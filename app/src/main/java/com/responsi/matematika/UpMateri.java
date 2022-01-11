package com.responsi.matematika;

public class UpMateri {

    public String judul;
    public String url;

    public UpMateri() {}

    public UpMateri (String judul, String url) {
        this.judul = judul;
        this.url = url;
    }

    public String getJudul() {
        return judul;
    }

    public String getUrl() {
        return url;
    }
}
