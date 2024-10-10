package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

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

    //////////////////////////////////////////////////////////////////////////////////
        });
        // ค้นหา Button
        Button backButton = findViewById(R.id.btnback);



        // ตั้งค่า OnClickListener ให้กับปุ่มย้อนกลับ
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ปิด Activity และกลับไปยัง Fragment
                finish();
            }
        });


        ////////////////////////////////////////////////////////////////


        // รับข้อมูลจาก Intent
        Intent intent = getIntent();
        String bodyPart = intent.getStringExtra("body_part");

        // ตรวจสอบ bodyPart และแสดงข้อมูลที่เหมาะสม
        if (bodyPart != null) {
            if (bodyPart.equals("ARM")) {
                // ตั้งค่าข้อมูลสำหรับ ARM
                setupArmExercises(intent);
            } else if (bodyPart.equals("LEG")) {
                // ตั้งค่าข้อมูลสำหรับ LEG
                setupLegExercises(intent);
            } else if (bodyPart.equals("ABDOMINAL")) {
                // ตั้งค่าข้อมูลสำหรับ CHEST
                setupAbdominalExercises(intent);
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////
    
    private void setupArmExercises(Intent intent) {
        String[] exerciseNames = intent.getStringArrayExtra("exercise_names");
        String[] imageUrls = intent.getStringArrayExtra("image_urls");

        // ตรวจสอบว่า array ไม่เป็น null และมีข้อมูล
        if (exerciseNames != null && imageUrls != null && exerciseNames.length >= 3 && imageUrls.length >= 3) {
            // แสดงรายละเอียดการฝึกใน TextView
            TextView txt1 = findViewById(R.id.txt1);
            TextView txt2 = findViewById(R.id.txt2);
            TextView txt3 = findViewById(R.id.txt3);

            txt1.setText(Html.fromHtml(exerciseNames[0]));
            txt2.setText(Html.fromHtml(exerciseNames[1]));
            txt3.setText(Html.fromHtml(exerciseNames[2]));

            // โหลดรูปภาพจาก URL ลงใน ImageView (ใช้ Glide)
            ImageView img1 = findViewById(R.id.img1);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[0])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img1);

            ImageView img2 = findViewById(R.id.img2);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[1])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img2);

            ImageView img3 = findViewById(R.id.img3);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[2])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img3);
        }


        RelativeLayout rtl_posture1 = findViewById(R.id.rtl_posture1);
        rtl_posture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ข้อมูลการออกกำลังกาย Push Up
                String exerciseDetails = "<span style=\"font-size:500px;\"><b>Push Up</b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• นอนคว่ำบนพื้น วางมือทั้งสองข้างไว้ข้างลำตัว ในระดับไหล่ (มือห่างจากกันประมาณหัวไหล่)<br>• วางนิ้วมือให้หันไปข้างหน้า หรืออาจหันไปด้านข้างเล็กน้อยตามความสะดวก<br>• ยกตัวขึ้นจากพื้นด้วยการใช้มือและปลายเท้า ตัวตรงจากศีรษะถึงส้นเท้า (เสมือนเป็นเส้นตรง)<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ Push-up:</b></span><br>• เริ่มต้นจากท่าแพลงก์ (Plank) ด้วยการเกร็งกล้ามเนื้อกลางลำตัว (Core) ให้แน่น<br>• หายใจเข้าแล้วค่อย ๆ ลดตัวลงโดยการงอข้อศอกให้แคบ (ข้อศอกหันเข้าหาลำตัว) จนหน้าอกใกล้กับพื้น<br>• รักษาหลังให้ตรง ไม่ให้สะโพกดันขึ้นหรือต่ำ<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ดันตัวกลับขึ้น:</b></span><br>• หายใจออก ขณะดันตัวกลับขึ้น โดยใช้แรงจากแขนและหน้าอก<br>• ดันตัวขึ้นจนแขนเหยียดตรง แต่ไม่ล็อกข้อศอก";

                // ส่งข้อมูลที่จำเป็นสำหรับท่าที่เลือก
                intent.putExtra("video_url", "https://www.youtube.com/embed/s3z0w-82Y00");
                intent.putExtra("exercise_details", exerciseDetails);

                // เริ่ม Activity และเพิ่ม Animation
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });






        RelativeLayout rtl_posture2 = findViewById(R.id.rtl_posture2);
        rtl_posture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);
                // ส่งข้อมูลท่าออกกำลังกาย triceps dip
                intent.putExtra("body_part", "ARM");
                intent.putExtra("video_url", "https://www.youtube.com/embed/ylee-wb_a0U");//เปลี่ยน url ข้างหลัง
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Triceps Dip</b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• หาม้านั่งหรือเก้าอี้ที่มั่นคง<br>• วางมือทั้งสองข้างบนขอบเก้าอี้ มืออยู่ใต้ไหล่ ปลายนิ้วหันไปด้านหน้า<br>• เหยียดขาไปข้างหน้าหรือวางเท้าราบกับพื้น งอเข่า 90 องศา (สำหรับมือใหม่) หรือเหยียดขาตรง (สำหรับขั้นสูง)<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ Dip:</b></span><br>• เริ่มต้นจากการยกตัวขึ้น โดยใช้แขนดันตัวให้ก้นลอยจากเก้าอี้<br>• ค่อย ๆ งอข้อศอก ลดตัวลงช้า ๆ จนแขนทำมุมประมาณ 90 องศา หลังตรงและใกล้กับขอบเก้าอี้<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ดันตัวกลับขึ้น:</b></span><br>• ดันตัวกลับขึ้นโดยใช้กำลังจากแขน (Triceps) ให้แขนเหยียดตรง แต่ไม่ล็อกข้อศอก");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });



        RelativeLayout rtl_diamond = findViewById(R.id.rtl_posture3);
        rtl_diamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);
                // ส่งข้อมูลท่าออกกำลังกาย diamond
                intent.putExtra("body_part", "ARM");
                intent.putExtra("video_url", "https://www.youtube.com/embed/XtU2VQVuLYs");//เปลี่ยน url ข้างหลัง
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Diamond Push Up</b></span><br><br>"+
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• เริ่มต้นด้วยการวางตัวในท่า Plank เหมือน Push-up ปกติ แต่ตำแหน่งมือจะวางต่างกัน<br>• วางมือทั้งสองข้างชิดกันใต้หน้าอก นิ้วหัวแม่มือและนิ้วชี้แตะกันเป็นรูปสามเหลี่ยม (หรือรูปเพชร) ซึ่งเป็นที่มาของชื่อ (Diamond Push-up)<br>• เท้ากว้างพอประมาณ หลังตรง ก้นไม่ยกสูงเกินไปหรือหย่อนลงต่ำเกินไป รักษาร่างกายให้เป็นเส้นตรง<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ Diamond Push Up:</b></span><br>• ค่อย ๆ งอข้อศอก ลดตัวลงช้า ๆ ให้หน้าอกเคลื่อนลงใกล้กับมือมากที่สุด<br>• รักษาความมั่นคงของแกนกลาง (Core) และพยายามให้หลังและสะโพกอยู่ในแนวตรง<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ดันตัวกลับขึ้น:</b></span><br>• ดันตัวกลับขึ้นโดยใช้กำลังจากแขนและหน้าอก จนแขนเหยียดตรง<br>• ระวังอย่าล็อกข้อศอกเมื่อเหยียดแขนตรงสุด");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });



    }
    private void setupLegExercises(Intent intent) {
        String[] exerciseNames = intent.getStringArrayExtra("exercise_names");
        String[] imageUrls = intent.getStringArrayExtra("image_urls");

        // ตรวจสอบว่า array ไม่เป็น null และมีข้อมูล
        if (exerciseNames != null && imageUrls != null && exerciseNames.length >= 3 && imageUrls.length >= 3) {
            // แสดงรายละเอียดการฝึกใน TextView
            TextView txt1 = findViewById(R.id.txt1);
            TextView txt2 = findViewById(R.id.txt2);
            TextView txt3 = findViewById(R.id.txt3);

            txt1.setText(Html.fromHtml(exerciseNames[0]));
            txt2.setText(Html.fromHtml(exerciseNames[1]));
            txt3.setText(Html.fromHtml(exerciseNames[2]));

            // โหลดรูปภาพจาก URL ลงใน ImageView (ใช้ Glide)
            ImageView img1 = findViewById(R.id.img1);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[0])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img1);

            ImageView img2 = findViewById(R.id.img2);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[1])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img2);

            ImageView img3 = findViewById(R.id.img3);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[2])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img3);
        }



///////////////////////////////////////////////////////////////////////////////////

        RelativeLayout rtl_Squat = findViewById(R.id.rtl_posture1);
        rtl_Squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ส่งข้อมูล URL วิดีโอและรายละเอียดการออกกำลังกายสำหรับท่า Squat
                intent.putExtra("video_url", "https://www.youtube.com/embed/D70cN_RoqP4");
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Squat</b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• ยืนตัวตรง แยกเท้าออกจากกันประมาณความกว้างของหัวไหล่<br>• ปล่อยแขนลงข้างลำตัว หรือวางไว้ข้างหน้าเพื่อสร้างสมดุล<br>• ย่อตัวลงเหมือนนั่งเก้าอี้ รักษาหลังให้ตรง ไม่งอ<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ Squat:</b></span><br>• งอเข่าและลดตัวลงจนต้นขาอยู่ขนานกับพื้น<br>• หายใจออกและดันตัวกลับขึ้นจนยืนตรง<br>• ทำซ้ำ 10-15 ครั้งสำหรับผู้เริ่มต้น หรือมากกว่านั้นตามความฟิต<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ประโยชน์:</b></span><br>• Squat เป็นท่าที่ดีในการสร้างความแข็งแรงของกล้ามเนื้อขาและแกนกลาง");

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });


        RelativeLayout rtl_Lunges = findViewById(R.id.rtl_posture2);
        rtl_Lunges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ส่งข้อมูล URL วิดีโอและรายละเอียดการออกกำลังกายสำหรับท่า Squat
                intent.putExtra("video_url", "https://www.youtube.com/embed/D70cN_RoqP4");
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Lunges</b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• ยืนตัวตรง แยกเท้าออกจากกันประมาณความกว้างของหัวไหล่<br>• ปล่อยแขนลงข้างลำตัว หรือวางไว้ข้างหน้าเพื่อสร้างสมดุล<br>• ย่อตัวลงเหมือนนั่งเก้าอี้ รักษาหลังให้ตรง ไม่งอ<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ Squat:</b></span><br>• งอเข่าและลดตัวลงจนต้นขาอยู่ขนานกับพื้น<br>• หายใจออกและดันตัวกลับขึ้นจนยืนตรง<br>• ทำซ้ำ 10-15 ครั้งสำหรับผู้เริ่มต้น หรือมากกว่านั้นตามความฟิต<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ประโยชน์:</b></span><br>• Squat เป็นท่าที่ดีในการสร้างความแข็งแรงของกล้ามเนื้อขาและแกนกลาง");

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });

        RelativeLayout rtl_Glute_Bridge = findViewById(R.id.rtl_posture3);
        rtl_Glute_Bridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ส่งข้อมูล URL วิดีโอและรายละเอียดการออกกำลังกายสำหรับท่า Squat
                intent.putExtra("video_url", "https://www.youtube.com/embed/NBmgEcVnOq8");
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Glute Bridge </b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• นอนหงายบนพื้นหรือเสื่อโยคะ งอเข่าและวางเท้าราบกับพื้น โดยให้เท้าห่างกันกว้างประมาณหัวไหล่<br>• วางแขนทั้งสองข้างขนานกับลำตัว ฝ่ามือวางราบกับพื้น<br>• ตรวจสอบให้แน่ใจว่าส้นเท้าอยู่ใกล้กับสะโพกพอที่จะดันตัวขึ้นได้สะดวก<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ  Glute Bridge:</b></span><br>• ดันส้นเท้าเพื่อดันสะโพกขึ้นจนตัวตั้งเป็นเส้นตรงจากหัวเข่าถึงไหล่<br>• ในขณะที่ดันสะโพกขึ้น ให้บีบกล้ามเนื้อก้น (Glutes) เพื่อให้ท่าได้ผลมากที่สุด<br>• ค้างท่านี้ไว้สักครู่ที่จุดสูงสุด (ประมาณ 1-2 วินาที)<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ลดตัวลง:</b></span><br>• ค่อยๆ ลดสะโพกลงจนเกือบแตะพื้น โดยยังคงความควบคุมในการเคลื่อนไหว");

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });
    }
    private void setupAbdominalExercises(Intent intent) {
        String[] exerciseNames = intent.getStringArrayExtra("exercise_names");
        String[] imageUrls = intent.getStringArrayExtra("image_urls");

        // ตรวจสอบว่า array ไม่เป็น null และมีข้อมูล
        if (exerciseNames != null && imageUrls != null && exerciseNames.length >= 3 && imageUrls.length >= 3) {
            // แสดงรายละเอียดการฝึกใน TextView
            TextView txt1 = findViewById(R.id.txt1);
            TextView txt2 = findViewById(R.id.txt2);
            TextView txt3 = findViewById(R.id.txt3);

            txt1.setText(Html.fromHtml(exerciseNames[0]));
            txt2.setText(Html.fromHtml(exerciseNames[1]));
            txt3.setText(Html.fromHtml(exerciseNames[2]));

            // โหลดรูปภาพจาก URL ลงใน ImageView (ใช้ Glide)
            ImageView img1 = findViewById(R.id.img1);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[0])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img1);

            ImageView img2 = findViewById(R.id.img2);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[1])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img2);

            ImageView img3 = findViewById(R.id.img3);
            Glide.with(this)
                    .asGif()
                    .load(imageUrls[2])
                    .placeholder(R.drawable.play)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                    .into(img3);
        }



///////////////////////////////////////////////////////////////////////////////////

        RelativeLayout rtl_Plank = findViewById(R.id.rtl_posture1);
        rtl_Plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ส่งข้อมูล URL วิดีโอและรายละเอียดการออกกำลังกายสำหรับท่า Squat
                intent.putExtra("video_url", "https://www.youtube.com/embed/jDZsXIkwWQ4");
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Plank</b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>•เริ่มในท่าคลานสี่ขา วางมือและเข่าลงกับพื้น<br>• เริ่มในท่าคลานสี่ขา วางมือและเข่าลงกับพื้น<br>• ขายืดตรงไปด้านหลังโดยให้ปลายเท้าวางบนพื้น<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ Plank:</b></span><br>• รักษาลำตัวให้ตรงตั้งแต่ศีรษะจนถึงเท้า อย่าให้สะโพกหย่อนลงหรือลอยขึ้นสูงเกินไป<br>• เกร็งกล้ามเนื้อหน้าท้องและก้น (Glutes) เพื่อให้ร่างกายอยู่ในท่าที่มั่นคงและแน่นหนาbr><br>" +
                        "<span style=\"font-size:30px;\"><b>การค้างท่า::</b></span><br>• ค้างท่านี้ให้นานที่สุดโดยที่ร่างกายยังคงอยู่ในท่าที่ถูกต้อง<br>• อย่าลืมหายใจเป็นปกติ ไม่กลั้นหายใจขณะทำท่า");

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });


        RelativeLayout rtl_Bicycle_Crunch = findViewById(R.id.rtl_posture2);
        rtl_Bicycle_Crunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ส่งข้อมูล URL วิดีโอและรายละเอียดการออกกำลังกายสำหรับท่า Squat
                intent.putExtra("video_url", "https://www.youtube.com/embed/dZ_shAbA1Vw");
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Bicycle Crunch</b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• นอนหงายบนพื้นหรือเสื่อโยคะ งอเข่าและวางเท้าบนพื้น<br>• วางมือทั้งสองข้างไว้ด้านหลังศีรษะหรือข้างหู (ไม่ควรดึงศีรษะ)<br>• ย่อตัวลงเหมือนนั่งเก้าอี้ รักษาหลังให้ตรง ไม่งอ<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ยกเข่าและไหล่:</b></span><br>• ยกเข่าขึ้นให้ทำมุมประมาณ 90 องศากับพื้น<br>• ยกหัวไหล่และลำตัวส่วนบนขึ้นจากพื้นเล็กน้อย โดยใช้กล้ามเนื้อหน้าท้องในการดึงตัวขึ้น<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เคลื่อนไหวร่างกาย:</b></span><br>• ยกเข่าขวาเข้าหาหัวอกขณะที่ยืดขาซ้ายออกไปตรงๆ (ให้ขาซ้ายลอยจากพื้นเล็กน้อย)<br>• บิดลำตัวพร้อมกับนำข้อศอกซ้ายมาบรรจบกับหัวเข่าขวาที่กำลังยกขึ้น<br>• สลับข้างโดยยืดเข่าขวาออกและนำเข่าซ้ายเข้าหาหัวอก ในขณะเดียวกันให้บิดลำตัวนำข้อศอกขวามาบรรจบกับหัวเข่าซ้าย<br>• ทำการเคลื่อนไหวอย่างต่อเนื่องเหมือนกำลังปั่นจักรยาน"+
                                "<span style=\"font-size:30px;\"><b>การควบคุมการเคลื่อนไหว:</b></span><br>• ควบคุมการเคลื่อนไหวให้เป็นไปอย่างช้าๆ และมั่นคงเพื่อให้กล้ามเนื้อหน้าท้องทำงานอย่างเต็มที่<br>• หายใจเข้าเมื่อคุณยืดขาออก และหายใจออกเมื่อคุณบิดลำตัวและนำเข่าขึ้น");

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });

        RelativeLayout rtl_Glute_Bridge = findViewById(R.id.rtl_posture3);
        rtl_Glute_Bridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent สำหรับเปิด Activity ที่แสดงวิดีโอ
                Intent intent = new Intent(Main_posture.this, Mainvidio1.class);

                // ส่งข้อมูล URL วิดีโอและรายละเอียดการออกกำลังกายสำหรับท่า Squat
                intent.putExtra("video_url", "https://www.youtube.com/embed/I4eRJ3Z_xTA");
                intent.putExtra("exercise_details", "<span style=\"font-size:500px;\"><b>Leg Raise </b></span><br><br>" +
                        "<span style=\"font-size:30px;\"><b>เตรียมตัว:</b></span><br>• นอนราบบนพื้นหรือเสื่อโยคะ วางมือทั้งสองข้างไว้ใต้สะโพกหรือด้านข้างลำตัว เพื่อช่วยพยุงหลังส่วนล่าง<br>• เหยียดขาตรงและวางขาทั้งสองข้างราบกับพื้น<br><br>" +
                        "<span style=\"font-size:30px;\"><b>เริ่มการ  Glute Bridge:</b></span><br>• เกร็งกล้ามเนื้อหน้าท้องและยกขาทั้งสองข้างขึ้นจากพื้น โดยให้ขาตรง ไม่งอเข่า<br>• ยกขาขึ้นไปจนทำมุมประมาณ 90 องศากับพื้น (หรือยกขึ้นเท่าที่สามารถทำได้โดยไม่ทำให้หลังส่วนล่างลอยขึ้นจากพื้น)<br><br>" +
                        "<span style=\"font-size:30px;\"><b>ลดขาลง:</b></span><br>• ค่อย ๆ ลดขาลงช้า ๆ โดยยังคงรักษาการควบคุมการเคลื่อนไหว ขาตรงตลอดการทำท่า<br>• ลดลงจนขาเกือบแตะพื้น แต่ไม่ให้ขาลงสัมผัสพื้น แล้วทำซ้ำ");

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // เพิ่ม Animation
            }
        });
    }
}