package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class BMIFragment extends Fragment {

    private EditText editTextWeight, editTextHeight;
    private Button buttonCalculate;

    public BMIFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b_m_i, container, false);

        // Initialize UI elements
        editTextWeight = view.findViewById(R.id.editTextWeight);
        editTextHeight = view.findViewById(R.id.editTextHeight);
        buttonCalculate = view.findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(v -> {
            String weightText = editTextWeight.getText().toString();
            String heightText = editTextHeight.getText().toString();

            if (!weightText.isEmpty() && !heightText.isEmpty()) {
                double weight = Double.parseDouble(weightText);
                double height = Double.parseDouble(heightText);

                double bmi = weight / (height * height);

                // Pass BMI result to ResultFragment
                Bundle bundle = new Bundle();
                bundle.putDouble("bmi_result", bmi);

                ResultFragment resultFragment = new ResultFragment();
                resultFragment.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .replace(R.id.fragmeentContainer, resultFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
