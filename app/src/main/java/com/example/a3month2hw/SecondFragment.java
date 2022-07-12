package com.example.a3month2hw;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondFragment extends Fragment {
    public final String SFTK = "second_fragment_text_key";
    private TextView tvTextSecond;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnNextSecond = view.findViewById(R.id.btn_next_second);
        tvTextSecond = view.findViewById(R.id.tv_text_second);
        MainFragment mainFragment = new MainFragment();
        if (getArguments() != null) {
            tvTextSecond.setText(getArguments().getString(mainFragment.MFTK));
        }

        btnNextSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvTextSecond.toString().isEmpty()){
                    Toast.makeText(requireContext(), "Пусто", Toast.LENGTH_LONG).show();
                }else {
                    ThirdFragment fragment = new ThirdFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(SFTK, tvTextSecond.getText().toString());
                    fragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().
                            add(R.id.container, fragment).addToBackStack("").commit();
                }
            }
        });
    }

}