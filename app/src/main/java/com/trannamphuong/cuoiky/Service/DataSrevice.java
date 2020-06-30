package com.trannamphuong.cuoiky.Service;

import com.trannamphuong.cuoiky.Model.GocNhin;
import com.trannamphuong.cuoiky.Model.MoiNhat;
import com.trannamphuong.cuoiky.Model.NoiDung;
import com.trannamphuong.cuoiky.Model.ThoiSu;
import com.trannamphuong.cuoiky.Model.TieuDe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataSrevice {
    @GET("tintuc/")
    Call<List<TieuDe>> getTieuDe();

    @GET("thoisu/")
    Call<List<ThoiSu>> getTieuDeThoiSu();

    @GET("gocnhin/")
    Call<List<GocNhin>> getTieuDeGocNhin();

    @GET("moinhat/")
    Call<List<MoiNhat>> getTieuDeMoiNhat();

    @FormUrlEncoded
    @POST("noidung/")
    Call<List<NoiDung>> getNoiDung(@Field("id") String id);



}
