package com.trannamphuong.cuoiky.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trannamphuong.cuoiky.R;

public class Fragment_ThoiSu extends Fragment {

    View v;
    Context context;

    public Fragment_ThoiSu(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_thoisu, container, false);
        return v;
    }
}