package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main_VDO_TricepsDip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vdo_triceps_dip);


        WebView vdo_triceps_dip = findViewById(R.id.vdo_triceps_dip);
        String vdeio_trisepsdip = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ylee-wb_a0U?si=4qXumlBiW7p3U3RI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        vdo_triceps_dip.loadData(vdeio_trisepsdip, "text/html", "utf-8");
        vdo_triceps_dip.getSettings().setJavaScriptEnabled(true);
        vdo_triceps_dip.setWebChromeClient(new WebChromeClient());


        // หาปุ่มจาก XML
        Button button = findViewById(R.id.btn_triceps_dip);

        // กำหนด OnClickListener ให้กับปุ่ม
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // สร้าง Intent เพื่อเปลี่ยน Activity
                Intent intent = new Intent(Main_VDO_TricepsDip.this, test_fire.class);
                startActivity(intent); // เรียกใช้งาน Activity อื่น
            }
        });


        Button btnback_vdo_tricepsdip = findViewById(R.id.btnback_vdo_tricepsdip);
        // ตั้งค่า OnClickListener ให้กับปุ่มย้อนกลับ
        btnback_vdo_tricepsdip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ปิด Activity และกลับไปยัง Fragment
                finish();
            }
        });
    }
}