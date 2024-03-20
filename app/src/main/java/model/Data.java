package model;

public class Data {

    private int id;
    private String fiyat;
    private String faturaNo;
    private String sozlesmeNo;
    private String timeStamp;

    public Data() {
    }

    public Data(String fiyat, String faturaNo, String sozlesmeNo) {
        this.fiyat = fiyat;
        this.faturaNo = faturaNo;
        this.sozlesmeNo = sozlesmeNo;
    }

    public Data(int id, String fiyat, String faturaNo, String sozlesmeNo) {
        this.id = id;
        this.fiyat = fiyat;
        this.faturaNo = faturaNo;
        this.sozlesmeNo = sozlesmeNo;
    }

    public Data(int id, String fiyat, String faturaNo, String sozlesmeNo, String timeStamp) {
        this.id = id;
        this.fiyat = fiyat;
        this.faturaNo = faturaNo;
        this.sozlesmeNo = sozlesmeNo;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

    public String getSozlesmeNo() {
        return sozlesmeNo;
    }

    public void setSozlesmeNo(String sozlesmeNo) {
        this.sozlesmeNo = sozlesmeNo;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
