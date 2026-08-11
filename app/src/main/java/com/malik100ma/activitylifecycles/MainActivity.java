package com.malik100ma.activitylifecycles;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected String TAG = "LIFE_CYCLE_DEBUG";

    protected TextView tvResumeCount, tvCreateCount, tvStartCount, tvPauseCount, tvStopCount;

    int onCreateCount = 0;

    int onResumeCount = 0;

    int onStartCount = 0;

    int onPauseCount = 0;

    int onStopCount = 0;

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
        tvCreateCount = findViewById(R.id.tvCreateCount);

        Log.d(TAG, "OnCreate");
        onCreateCount++;
        tvCreateCount.setText(onCreateCount);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        tvStartCount = findViewById(R.id.tvOnStartCount);
        onStartCount++;
        tvStartCount.setText(onStartCount);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        tvResumeCount = findViewById(R.id.tvResumeCount);
        onResumeCount++;
        tvResumeCount.setText(onResumeCount);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tvPauseCount = findViewById(R.id.tvPauseCount);
        Log.d(TAG, "onPause");
        onPauseCount++;
        tvPauseCount.setText(onPauseCount);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        tvResumeCount = findViewById(R.id.tvStopCount);
        onStopCount++;
        tvStopCount.setText(onStopCount);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }
}