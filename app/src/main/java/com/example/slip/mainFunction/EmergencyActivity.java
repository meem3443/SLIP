package com.example.slip.mainFunction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.slip.R;
import com.example.slip.databinding.ActivityEmergencyBinding;

public class EmergencyActivity extends AppCompatActivity {

    private ActivityEmergencyBinding binding;
    private boolean isFull = false;
    private FrameLayout videoFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmergencyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final TextView place = binding.place;
        final VideoView monitor = binding.videoView;
        final Button confirmBtn = binding.confirmBtn;
        final Button fullScreenBtn = binding.fullscreenBtn;
        videoFrame = binding.videoFrame;

        String path = "android.resource://" + getPackageName() + "/" + R.raw.example_video;
        Uri uri = Uri.parse(path);
        monitor.setVideoURI(uri);

        Intent intent = getIntent();
        place.setText(intent.getStringExtra("place"));

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        fullScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFullScreen(true);
            }
        });



        monitor.start();
    }

    @Override
    public void onBackPressed() {
        if (isFull) {
            isFull = false;
            ViewGroup.LayoutParams params = videoFrame.getLayoutParams();
            ConstraintLayout.LayoutParams mLayoutParams = (ConstraintLayout.LayoutParams) videoFrame.getLayoutParams();

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            params.height = (int)(metrics.density * 200);
            mLayoutParams.topMargin = (int)(metrics.density * 40);;
            mLayoutParams.leftMargin = (int)(metrics.density * 20);;
            mLayoutParams.rightMargin = (int)(metrics.density * 20);;

            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            super.onBackPressed();
        }
    }

    private void setFullScreen(boolean full) {
        isFull = full;
        ViewGroup.LayoutParams params = videoFrame.getLayoutParams();
        ConstraintLayout.LayoutParams mLayoutParams = (ConstraintLayout.LayoutParams) videoFrame.getLayoutParams();

        if (isFull) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            mLayoutParams.topMargin = 6;
            mLayoutParams.leftMargin = 0;
            mLayoutParams.rightMargin = 0;
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int height = (int)(metrics.density * 200);
            params.height = height;

            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}