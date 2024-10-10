package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Mainvidio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainvidio1);


        // รับ URL ของวิดีโอจาก Intent
        String videoUrl = getIntent().getStringExtra("video_url");
        String exerciseDetails = getIntent().getStringExtra("exercise_details");

        // ตั้งค่า WebView
        WebView webView = findViewById(R.id.vdo_1);
        webView.getSettings().setJavaScriptEnabled(true);  // เปิดการใช้งาน JavaScript

        // ฝังวิดีโอ YouTube ด้วย iframe HTML
        String iframe = "<iframe width=\"100%\" height=\"100%\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe>";
        webView.loadDataWithBaseURL(null, iframe, "text/html", "utf-8", null);

        // แสดงรายละเอียดท่าการออกกำลังกาย
        TextView detailsTextView = findViewById(R.id.txt_vdo1);
        detailsTextView.setText(Html.fromHtml(exerciseDetails));








        // หาปุ่มจาก XML
        Button button = findViewById(R.id.buttonvdo1);

        // กำหนด OnClickListener ให้กับปุ่ม
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // สร้าง Intent เพื่อเปลี่ยน Activity
                Intent intent = new Intent(Mainvidio1.this, test_fire.class);
                startActivity(intent); // เรียกใช้งาน Activity อื่น
            }
        });


        Button btnback_vdo_phus_up = findViewById(R.id.btnback_vdo_phus_up);
        // ตั้งค่า OnClickListener ให้กับปุ่มย้อนกลับ
        btnback_vdo_phus_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ปิด Activity และกลับไปยัง Fragment
                finish();
            }
        });




    }
}
