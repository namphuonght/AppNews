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

import com.trannamphuong.cuoiky.Adapter.MoiNhatAdapter;
import com.trannamphuong.cuoiky.Model.MoiNhat;
import com.trannamphuong.cuoiky.R;
import com.trannamphuong.cuoiky.Service.APIService;
import com.trannamphuong.cuoiky.Service.DataSrevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_MoiNhat extends Fragment {

    RecyclerView recyclerViewTieuDeMoiNhat;
    MoiNhatAdapter moiNhatAdapter;
    View view;

    public Fragment_MoiNhat(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_moinhat, container, false);
        recyclerViewTieuDeMoiNhat = view.findViewById(R.id.rv_tieudemoinhat);
        GetData();
        return view;
    }

    private void GetData() {
        DataSrevice dataService = APIService.getService();
        Call<List<MoiNhat>> callBack = dataService.getTieuDeMoiNhat();
        callBack.enqueue(new Callback<List<MoiNhat>>() {
            @Override
            public void onResponse(Call<List<MoiNhat>> call, Response<List<MoiNhat>> response) {
                ArrayList<MoiNhat> tieuDeArrayList = (ArrayList<MoiNhat>) response.body();
                moiNhatAdapter = new MoiNhatAdapter(getActivity(), tieuDeArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewTieuDeMoiNhat.setLayoutManager(linearLayoutManager);
                recyclerViewTieuDeMoiNhat.setAdapter(moiNhatAdapter);
            }

            @Override
            public void onFailure(Call<List<MoiNhat>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }
}