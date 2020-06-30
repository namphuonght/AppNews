package com.trannamphuong.cuoiky.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trannamphuong.cuoiky.Adapter.GocNhinAdapter;
import com.trannamphuong.cuoiky.Model.GocNhin;
import com.trannamphuong.cuoiky.R;
import com.trannamphuong.cuoiky.Service.APIService;
import com.trannamphuong.cuoiky.Service.DataSrevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_GocNhin extends Fragment {

    RecyclerView recyclerViewTieuDeGocNhin;
    GocNhinAdapter gocNhinAdapter;
    View view;

    public Fragment_GocNhin(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gocnhin, container, false);
        recyclerViewTieuDeGocNhin = view.findViewById(R.id.rv_tieudegocnhin);
        GetData();
        return view;
    }

    private void GetData() {
        DataSrevice dataService = APIService.getService();
        Call<List<GocNhin>> callBack = dataService.getTieuDeGocNhin();
        callBack.enqueue(new Callback<List<GocNhin>>() {
            @Override
            public void onResponse(Call<List<GocNhin>> call, Response<List<GocNhin>> response) {
                ArrayList<GocNhin> tieuDeArrayList = (ArrayList<GocNhin>) response.body();
                gocNhinAdapter = new GocNhinAdapter(getActivity(), tieuDeArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewTieuDeGocNhin.setLayoutManager(linearLayoutManager);
                recyclerViewTieuDeGocNhin.setAdapter(gocNhinAdapter);
            }

            @Override
            public void onFailure(Call<List<GocNhin>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }
}
