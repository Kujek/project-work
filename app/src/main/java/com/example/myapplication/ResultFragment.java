package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {

    private TextView textViewResult;

    public ResultFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        // Initialize UI element
        textViewResult = view.findViewById(R.id.textViewResult);

        // Get BMI result from arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            double bmi = bundle.getDouble("bmi_result");
            textViewResult.setText("Your BMI is: " + String.format("%.2f", bmi));
        }

        return view;
    }
}
