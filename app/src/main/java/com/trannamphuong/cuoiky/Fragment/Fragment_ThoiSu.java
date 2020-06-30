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

import com.trannamphuong.cuoiky.Adapter.ThoiSuAdapter;
import com.trannamphuong.cuoiky.Model.ThoiSu;
import com.trannamphuong.cuoiky.R;
import com.trannamphuong.cuoiky.Service.APIService;
import com.trannamphuong.cuoiky.Service.DataSrevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ThoiSu extends Fragment {

    RecyclerView recyclerViewTieuDeThoiSu;
    ThoiSuAdapter thoiSuAdapter;
    View view;

    public Fragment_ThoiSu(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thoisu, container, false);
        recyclerViewTieuDeThoiSu = view.findViewById(R.id.rv_tieudethoisu);
        GetData();
        return view;
    }

    private void GetData() {
        DataSrevice dataService = APIService.getService();
        Call<List<ThoiSu>> callBack = dataService.getTieuDeThoiSu();
        callBack.enqueue(new Callback<List<ThoiSu>>() {
            @Override
            public void onResponse(Call<List<ThoiSu>> call, Response<List<ThoiSu>> response) {
                ArrayList<ThoiSu> tieuDeArrayList = (ArrayList<ThoiSu>) response.body();
                thoiSuAdapter = new ThoiSuAdapter(getActivity(), tieuDeArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewTieuDeThoiSu.setLayoutManager(linearLayoutManager);
                recyclerViewTieuDeThoiSu.setAdapter(thoiSuAdapter);
            }

            @Override
            public void onFailure(Call<List<ThoiSu>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }
}
