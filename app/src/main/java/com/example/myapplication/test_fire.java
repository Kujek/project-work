package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class test_fire extends AppCompatActivity {
    private TextView textViewTime;
    private Button buttonStart, buttonIncreaseTime, buttonDecreaseTime, buttonReset;

    private long startTimeInMillis = 60000; // ค่าเริ่มต้น 60 วินาที (1 นาที)
    private long timeInMillis = startTimeInMillis; // เวลาที่ใช้นับถอยหลัง
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_fire);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView fireImage = findViewById(R.id.fire); // ระบุ ID ของรูป
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fire_animation);
        fireImage.startAnimation(animation);



        textViewTime = findViewById(R.id.textViewTime1);
        buttonStart = findViewById(R.id.buttonStart);
        buttonIncreaseTime = findViewById(R.id.buttonIncreaseTime);
        buttonDecreaseTime = findViewById(R.id.buttonDecreaseTime);
        buttonReset = findViewById(R.id.buttonReset); // อ้างอิงปุ่มรีเซ็ต

        updateTimeText();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    startTimer();
                } else {
                    pauseTimer();
                }
            }
        });

        buttonIncreaseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    timeInMillis += 10000; // เพิ่มเวลา 10 วินาที
                    startTimeInMillis = timeInMillis; // อัปเดตค่าเริ่มต้นใหม่
                    updateTimeText();
                }
            }
        });

        buttonDecreaseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning && timeInMillis > 10000) {
                    timeInMillis -= 10000; // ลดเวลา 10 วินาที
                    startTimeInMillis = timeInMillis; // อัปเดตค่าเริ่มต้นใหม่
                    updateTimeText();
                } else {
                    Toast.makeText(test_fire.this, "เวลาเหลือน้อยเกินไป", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer(); // กำหนดการทำงานให้กับปุ่มรีเซ็ต
            }
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeInMillis = millisUntilFinished;
                updateTimeText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                buttonStart.setText("เริ่ม");
                timeInMillis = startTimeInMillis; // รีเซ็ตเวลากลับไปค่าเริ่มต้น
                updateTimeText(); // อัปเดตเวลาใหม่บนหน้าจอ
            }
        }.start();

        timerRunning = true;
        buttonStart.setText("หยุด");
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        buttonStart.setText("เริ่ม");
    }

    private void resetTimer() {
        timeInMillis = startTimeInMillis; // รีเซ็ตเวลาไปที่ค่าเริ่มต้น
        updateTimeText(); // อัปเดตเวลาใหม่บนหน้าจอ

        if (timerRunning) {
            pauseTimer(); // หยุดการนับถอยหลังถ้ากำลังทำงาน
        }

        buttonStart.setText("เริ่ม"); // เปลี่ยนปุ่มกลับไปเป็น 'เริ่ม'
    }

    private void updateTimeText() {
        int minutes = (int) (timeInMillis / 1000) / 60;
        int seconds = (int) (timeInMillis / 1000) % 60;

        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        textViewTime.setText(timeFormatted);
    }
}