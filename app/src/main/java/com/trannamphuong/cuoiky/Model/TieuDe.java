package com.trannamphuong.cuoiky.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TieuDe {

    @SerializedName("tieu_de")
    @Expose
    private String tieuDe;
    @SerializedName("url_img")
    @Expose
    private String urlImg;
    @SerializedName("mo_ta")
    @Expose
    private String moTa;

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}