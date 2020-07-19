package com.trannamphuong.cuoiky.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trannamphuong.cuoiky.Activity.LoginActivity;
import com.trannamphuong.cuoiky.R;

public class Fragment_Account extends Fragment {
    View view;
    Button btnSign_in;

    public Fragment_Account() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);

        btnSign_in = view.findViewById(R.id.sign_in);
        btnSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
