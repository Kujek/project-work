package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // ค้นหา RelativeLayout และตั้งค่า OnClickListener
        RelativeLayout goToPosture = view.findViewById(R.id.go1);
        RelativeLayout goToPostureLeg = view.findViewById(R.id.go2);
        goToPosture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // แสดง BottomSheet
                Intent intent = new Intent(getActivity(),Main_posture.class); // เปลี่ยน Mainvidio1 เป็น Activity ที่คุณต้องการเปิด
                startActivity(intent); // เปิด Activity
            }
        });
        goToPostureLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Main_posture_leg.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
