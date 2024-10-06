package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
public class Main_posture extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_posture);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainposture), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        // ค้นหา Button
        Button backButton = findViewById(R.id.btnback);
        RelativeLayout relativeLayout = findViewById(R.id.arm1);

        // ตั้งค่า OnClickListener ให้กับปุ่มย้อนกลับ
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ปิด Activity และกลับไปยัง Fragment
                finish();
            }
        });
        // กำหนด OnClickListener สำหรับ RelativeLayout
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // สร้าง Intent เพื่อเปลี่ยน Activity
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);
                startActivity(intent);
            }
        });






    }
}