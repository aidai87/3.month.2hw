package com.example.a3month2hw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ThirdFragment extends Fragment {
private TextView tvResult;
private Button btnReturn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvResult = view.findViewById(R.id.tv_text_third);
        btnReturn = view.findViewById(R.id.btn_return_first_fragment);
        SecondFragment secondFragment = new SecondFragment();
        if (getArguments() != null) {
            tvResult.setText(getArguments().getString(secondFragment.SFTK));
        }
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new MainFragment()).addToBackStack(null).commit();
            }
        });

    }
}