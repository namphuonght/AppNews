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

import com.trannamphuong.cuoiky.Adapter.TieuDeAdapter;
import com.trannamphuong.cuoiky.Model.TieuDe;
import com.trannamphuong.cuoiky.R;
import com.trannamphuong.cuoiky.Service.APIService;
import com.trannamphuong.cuoiky.Service.DataSrevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_TrangNhat extends Fragment {
    RecyclerView recyclerViewTieuDe;
    TieuDeAdapter tieuDeAdapter;
    View view;

    public Fragment_TrangNhat(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_trangnhat, container, false);
        recyclerViewTieuDe = view.findViewById(R.id.rv_tieude);
        GetData(); 
        return view;
    }

    private void GetData() {
        DataSrevice dataService = APIService.getService();
        Call<List<TieuDe>> callBack = dataService.getTieuDe();
        callBack.enqueue(new Callback<List<TieuDe>>() {
            @Override
            public void onResponse(Call<List<TieuDe>> call, Response<List<TieuDe>> response) {
                ArrayList<TieuDe> tieuDeArrayList = (ArrayList<TieuDe>) response.body();
                tieuDeAdapter = new TieuDeAdapter(getActivity(), tieuDeArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewTieuDe.setLayoutManager(linearLayoutManager);
                recyclerViewTieuDe.setAdapter(tieuDeAdapter);
            }

            @Override
            public void onFailure(Call<List<TieuDe>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }

}
