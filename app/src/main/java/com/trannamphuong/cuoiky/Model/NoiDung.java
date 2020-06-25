package com.trannamphuong.cuoiky.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoiDung {

    @SerializedName("tieude")
    @Expose
    private String tieude;
    @SerializedName("mo_bai")
    @Expose
    private String moBai;
    @SerializedName("url_imgNoiDung")
    @Expose
    private String urlImgNoiDung;
    @SerializedName("ket_bai")
    @Expose
    private String ketBai;

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getMoBai() {
        return moBai;
    }

    public void setMoBai(String moBai) {
        this.moBai = moBai;
    }

    public String getUrlImgNoiDung() {
        return urlImgNoiDung;
    }

    public void setUrlImgNoiDung(String urlImgNoiDung) {
        this.urlImgNoiDung = urlImgNoiDung;
    }

    public String getKetBai() {
        return ketBai;
    }

    public void setKetBai(String ketBai) {
        this.ketBai = ketBai;
    }

}