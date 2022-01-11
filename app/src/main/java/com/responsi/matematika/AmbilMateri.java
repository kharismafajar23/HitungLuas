package com.responsi.matematika;

public class AmbilMateri {

    public String judul;
    public String url;

    public AmbilMateri() {
    }

    public AmbilMateri(String judul, String url) {
        this.judul = judul;
        this.url = url;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
