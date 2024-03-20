package model;

public class User {

    private String adSoyad , email , sifre , kimlik , sosyalYardim;
    public User() {

    }

    public User(String adSoyad, String email, String sifre, String kimlik, String sosyalYardim) {
        this.adSoyad = adSoyad;
        this.email = email;
        this.sifre = sifre;
        this.kimlik = kimlik;
        this.sosyalYardim = sosyalYardim;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKimlik() {
        return kimlik;
    }

    public void setKimlik(String kimlik) {
        this.kimlik = kimlik;
    }

    public String getSosyalYardim() {
        return sosyalYardim;
    }

    public void setSosyalYardim(String sosyalYardim) {
        this.sosyalYardim = sosyalYardim;
    }
}
