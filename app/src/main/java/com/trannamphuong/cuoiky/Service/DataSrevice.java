package com.trannamphuong.cuoiky.Service;

import com.trannamphuong.cuoiky.Model.NoiDung;
import com.trannamphuong.cuoiky.Model.TieuDe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataSrevice {
    @GET("tintuc")
    Call<List<TieuDe>> getTieuDe();

    @GET("noidung")
    Call<List<NoiDung>> getNoiDung();
}
