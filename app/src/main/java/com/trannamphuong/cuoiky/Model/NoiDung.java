package com.trannamphuong.cuoiky.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoiDung {

    @SerializedName("tieude")
    @Expose
    private Integer tieude;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("url_imgNoiDung")
    @Expose
    private String urlImgNoiDung;
    @SerializedName("url_video")
    @Expose
    private String urlVideo;

    public Integer getTieude() {
    return tieude;
    }

    public void setTieude(Integer tieude) {
    this.tieude = tieude;
    }

    public String getNoiDung() {
    return noiDung;
    }

    public void setNoiDung(String noiDung) {
    this.noiDung = noiDung;
    }

    public String getUrlImgNoiDung() {
    return urlImgNoiDung;
    }

    public void setUrlImgNoiDung(String urlImgNoiDung) {
    this.urlImgNoiDung = urlImgNoiDung;
    }

    public String getUrlVideo() {
    return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
    this.urlVideo = urlVideo;
    }

}