package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int selectedTab = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmeentContainer, new BMIFragment())
                    .commit(); // ปิดวงเล็บที่ commit()
        }



        final LinearLayout homeLayout = findViewById(R.id.main_home);
        final LinearLayout foodLayout = findViewById(R.id.main_food);
        final LinearLayout bmiLayout = findViewById(R.id.main_bmi);

        final ImageView homeImage = findViewById(R.id.img_home);
        final ImageView foodImage = findViewById(R.id.img_food);
        final ImageView bmiImage = findViewById(R.id.img_bmi);

        final TextView homeText = findViewById(R.id.text_home);
        final TextView foodText = findViewById(R.id.text_food);
        final TextView bmiText = findViewById(R.id.text_bmi);


        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmeentContainer, HomeFragment.class, null)
                                .commit();





        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 1){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmeentContainer, HomeFragment.class, null)
                            .commit();
                    foodText.setVisibility(View.GONE);
                    bmiText.setVisibility(View.GONE);

                    foodImage.setImageResource(R.drawable.icon_food);
                    bmiImage.setImageResource(R.drawable.icon_bmi);


                    foodLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    bmiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    homeText.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.like_icon_home);
                    homeLayout.setBackgroundResource(R.drawable.round_back_home);


                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);


                    selectedTab = 1;

                }


            }
        });

        foodLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // โหลด HomeFragment เมื่อ Activity เริ่มต้น
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmeentContainer, new HomeFragment())
                            .commit();
                }

                if(selectedTab != 2){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmeentContainer, FoodFragment.class, null)
                            .commit();
                    homeText.setVisibility(View.GONE);
                    bmiText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icon_home);
                    bmiImage.setImageResource(R.drawable.icon_bmi);


                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    bmiLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    foodText.setVisibility(View.VISIBLE);
                    foodImage.setImageResource(R.drawable.like_icon_food);
                    foodLayout.setBackgroundResource(R.drawable.round_back_home);


                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    foodLayout.startAnimation(scaleAnimation);


                    selectedTab = 2;

                }

            }
        });

        bmiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab != 3){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmeentContainer, BMIFragment.class, null)
                            .commit();
                    homeText.setVisibility(View.GONE);
                    foodText.setVisibility(View.GONE);

                    foodImage.setImageResource(R.drawable.icon_food);
                    homeImage.setImageResource(R.drawable.icon_home);


                    foodLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    bmiText.setVisibility(View.VISIBLE);
                    bmiImage.setImageResource(R.drawable.like_icon_bmi);
                    bmiLayout.setBackgroundResource(R.drawable.round_back_home);


                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    bmiLayout.startAnimation(scaleAnimation);


                    selectedTab = 3;

                }

            }
        });




    }

}