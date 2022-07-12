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
import android.widget.Toast;


public class MainFragment extends Fragment {
    public final String MFTK = "main_fragment_text_key";
    private Button btnNext;
    private EditText etText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = view.findViewById(R.id.btn_next);
        etText = view.findViewById(R.id.et_text);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etText.toString().isEmpty()){
                    Toast.makeText(requireContext(), "Пусто", Toast.LENGTH_LONG).show();
                }else {
                    SecondFragment fragment = new SecondFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(MFTK, etText.getText().toString());
                    fragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().
                            replace(R.id.container, fragment).addToBackStack(null).commit();
                }
            }
        });
    }
}