package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
public class Mainvidio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainvidio1);


        WebView webView = findViewById(R.id.webView1);
        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/s3z0w-82Y00?si=eswtJlGYhpqDxmuV\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html","utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());


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




    }
}
