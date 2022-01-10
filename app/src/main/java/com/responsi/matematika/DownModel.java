package com.responsi.matematika;

public class DownModel {

    String Judul, Link;

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
    public DownModel(String Judul, String Link){
        this.Judul=Judul;
        this.Link=Link;
    }
}
