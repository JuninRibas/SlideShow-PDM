package com.example.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    private int currentIndex = 0;

    private ImageView imageView;
    private Button homeButton;
    private Button prevButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        homeButton = (Button) findViewById(R.id.homeButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        imageView.setImageResource(imageIds[currentIndex]);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = 0;
                imageView.setImageResource(imageIds[currentIndex]);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = imageIds.length - 1;
                }
                imageView.setImageResource(imageIds[currentIndex]);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex >= imageIds.length) {
                    currentIndex = 0;
                }
                imageView.setImageResource(imageIds[currentIndex]);
            }
        });
    }
}