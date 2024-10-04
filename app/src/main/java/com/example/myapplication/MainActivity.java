package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int SelectedTab = 1;




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

        final LinearLayout homeLayout = findViewById(R.id.main_home);
        final LinearLayout foodLayout = findViewById(R.id.main_food);
        final LinearLayout bmiLayout = findViewById(R.id.main_bmi);

        final ImageView homeImage = findViewById(R.id.img_home);
        final ImageView foodImage = findViewById(R.id.img_food);
        final ImageView bmiImage = findViewById(R.id.img_bmi);

        final TextView homeText = findViewById(R.id.text_home);
        final TextView foodText = findViewById(R.id.text_food);
        final TextView bmiText = findViewById(R.id.text_bmi);



        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if()

            }
        });

        foodLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bmiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }

}