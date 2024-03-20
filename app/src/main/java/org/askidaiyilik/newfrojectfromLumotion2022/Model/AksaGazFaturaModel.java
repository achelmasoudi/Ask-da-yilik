package org.askidaiyilik.newfrojectfromLumotion2022.Model;

public class AksaGazFaturaModel {

    private String faturaTarihi;
    private String faturaFiyati;

    public AksaGazFaturaModel() {

    }

    public AksaGazFaturaModel(String faturaTarihi, String faturaFiyati) {
        this.faturaTarihi = faturaTarihi;
        this.faturaFiyati = faturaFiyati;
    }

    public String getFaturaTarihi() {
        return faturaTarihi;
    }

    public void setFaturaTarihi(String faturaTarihi) {
        this.faturaTarihi = faturaTarihi;
    }

    public String getFaturaFiyati() {
        return faturaFiyati;
    }

    public void setFaturaFiyati(String faturaFiyati) {
        this.faturaFiyati = faturaFiyati;
    }
}
