package com.trannamphuong.cuoiky.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trannamphuong.cuoiky.Adapter.TimKiemAdapter;
import com.trannamphuong.cuoiky.Model.TieuDe;
import com.trannamphuong.cuoiky.R;
import com.trannamphuong.cuoiky.Service.APIService;
import com.trannamphuong.cuoiky.Service.DataSrevice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Search extends Fragment {
    View view;
    RecyclerView rvSearch;
    TextView textViewNotData;
    SearchView searchView;
    TimKiemAdapter timKiemAdapter;

    public Fragment_Search(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        rvSearch = view.findViewById(R.id.rvsearch);
        textViewNotData = view.findViewById(R.id.tvnotdata);
        searchView = view.findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchTuKhoaBaiViet(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;
    }
    private void SearchTuKhoaBaiViet(String query){
        DataSrevice dataSrevice = APIService.getService();
        Call<List<TieuDe>> callBack = dataSrevice.getTimKiem(query);
        callBack.enqueue(new Callback<List<TieuDe>>() {
            @Override
            public void onResponse(Call<List<TieuDe>> call, Response<List<TieuDe>> response) {
                ArrayList<TieuDe> arrTimKiem = (ArrayList<TieuDe>) response.body();
                if(arrTimKiem.size()>0){
                    timKiemAdapter = new TimKiemAdapter(getActivity(), arrTimKiem);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    rvSearch.setLayoutManager(linearLayoutManager);
                    rvSearch.setAdapter(timKiemAdapter);
                    textViewNotData.setVisibility(View.GONE);
                    rvSearch.setVisibility(View.VISIBLE);
                }
                else{
                    rvSearch.setVisibility(View.GONE);
                    textViewNotData.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<TieuDe>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
    }
}
