package com.trannamphuong.cuoiky.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trannamphuong.cuoiky.Adapter.NoiDungAdapter;
import com.trannamphuong.cuoiky.Model.NoiDung;
import com.trannamphuong.cuoiky.Model.TieuDe;
import com.trannamphuong.cuoiky.R;
import com.trannamphuong.cuoiky.Service.APIService;
import com.trannamphuong.cuoiky.Service.DataSrevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoidungActivity extends AppCompatActivity {

    TieuDe tieuDe;
    RecyclerView recyclerViewNoiDung;
    TextView tvTieuDe, tvMoTa;
    NoiDungAdapter noiDungAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noidung);
        GetIntent();
        init();
        GetData();
    }

    private void GetData() {
        DataSrevice dataSrevice = APIService.getService();
        Call<List<NoiDung>> callBack = dataSrevice.getNoiDung(tieuDe.getIdTintuc());
        callBack.enqueue(new Callback<List<NoiDung>>() {
            @Override
            public void onResponse(Call<List<NoiDung>> call, Response<List<NoiDung>> response) {
                ArrayList<NoiDung> mangNoiDung = (ArrayList<NoiDung>) response.body();
                noiDungAdapter = new NoiDungAdapter(NoidungActivity.this, mangNoiDung);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NoidungActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewNoiDung.setLayoutManager(linearLayoutManager);
                recyclerViewNoiDung.setAdapter(noiDungAdapter);
            }

            @Override
            public void onFailure(Call<List<NoiDung>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });

    }

    private void init() {
        recyclerViewNoiDung = findViewById(R.id.rv_noidung);

    }

    private void GetIntent() {
        Intent intent = getIntent();
        if(intent.hasExtra("tieude")){
            tieuDe = (TieuDe) intent.getSerializableExtra("tieude");
        }
    }
}
