package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
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

        ////////////////////////////////////////////////////////////////////////

        //ARM
        RelativeLayout rtl_go1 = view.findViewById(R.id.go1);
        rtl_go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(getActivity(), Main_posture.class);
                // ส่งข้อมูลที่จำเป็นสำหรับท่าที่เลือก
                intent.putExtra("body_part", "ARM"); // ระบุว่าเลือก ARM
                //เพิ่มชื่อ
                intent.putExtra("exercise_names", new String[]{
                                "<span style=\"font-size:50px;\"><b>Push Up</b></span>",
                                "<span style=\"font-size:50px;\"><b>Tricep Dip</b></span>",
                                "<span style=\"font-size:50px;\"><b>Diamond Push Up</b></span>"
                        });


                intent.putExtra("image_urls", new String[]{
                        "https://www.inspireusafoundation.org/wp-content/uploads/2022/11/push-up.gif",
                        "https://i.pinimg.com/originals/40/8a/29/408a29849ef328ac26eaec7d972874e7.gif",
                        "https://i.pinimg.com/originals/f9/1e/25/f91e252ccec48090bf58266cc20b0742.gif"
                });
                startActivity(intent);
            }
        });

        //LEG
        RelativeLayout rtl_go2 = view.findViewById(R.id.go2);
        rtl_go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(getActivity(), Main_posture.class);
                // ส่งข้อมูลที่จำเป็นสำหรับท่าที่เลือก
                intent.putExtra("body_part", "LEG"); // ระบุว่าเลือก ARM

                intent.putExtra("exercise_names", new String[]{
                        "<span style=\"font-size:50px;\"><b>Squat Up</b></span>",
                        "<span style=\"font-size:50px;\"><b>Lunges Dip</b></span>",
                        "<span style=\"font-size:50px;\"><b>Glute Bridge</b></span>"
                });
                intent.putExtra("image_urls", new String[]{
                        "https://i.pinimg.com/originals/05/6c/b3/056cb383a8051624bd213013006f73a2.gif",
                        "https://i.pinimg.com/originals/59/22/f3/5922f3e5a2e65a74d14da1cb094fc83c.gif",
                        "https://i.pinimg.com/originals/81/06/d4/8106d4d5f00a226f368bf0c4d201ab50.gif"
                });
                startActivity(intent);
                }



        });

        //Abdominal
        RelativeLayout rtl_go3 = view.findViewById(R.id.go3);
        rtl_go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(getActivity(), Main_posture.class);
                // ส่งข้อมูลที่จำเป็นสำหรับท่าที่เลือก
                intent.putExtra("body_part", "ABDOMINAL"); // ระบุว่าเลือก ARM

                intent.putExtra("exercise_names", new String[]{
                        "<span style=\"font-size:50px;\"><b>Plank </b></span>",
                        "<span style=\"font-size:50px;\"><b>Bicycle Crunch</b></span>",
                        "<span style=\"font-size:50px;\"><b>Leg Raise</b></span>"
                });
                intent.putExtra("image_urls", new String[]{
                        "https://i.pinimg.com/originals/65/ba/d0/65bad0c0b29846b7ff4d82c312dd4471.gif",
                        "https://i.pinimg.com/originals/d9/cc/c9/d9ccc911504c370177f0da0c3289b184.gif",
                        "https://i.pinimg.com/originals/0f/a7/46/0fa74623d5be37c74b11fec1e8f04db4.gif"
                });
                startActivity(intent);
            }



        });



        return view;
    }
}
