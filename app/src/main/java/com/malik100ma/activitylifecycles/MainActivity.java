package com.malik100ma.activitylifecycles;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected String TAG = "LIFE_CYCLE_DEBUG";

    protected TextView totalCreateCount, tvCreateCount;

    int onCreateCount = 0;

    int onTotalCreateCount = 0;


    SharedPreferences sharedPreferences;
    private static final String KEY_PREFERENCES = "total_creates";


    @SuppressLint("MissingInflatedId")
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


        Log.d(TAG, "OnCreate");
        sharedPreferences = getSharedPreferences("livecycles_prefs", MODE_PRIVATE);
        if (savedInstanceState != null) {
            onCreateCount = savedInstanceState.getInt("keyOnCreate");
        }
        onTotalCreateCount = sharedPreferences.getInt(KEY_PREFERENCES,0);
        onCreateCount += 1;
        tvCreateCount = findViewById(R.id.tvCreateCount);
        totalCreateCount = findViewById(R.id.totalCreateCount);
        tvCreateCount.setText(String.valueOf(onCreateCount));
        totalCreateCount.setText(String.valueOf(onTotalCreateCount));

        sharedPreferences.edit().putInt(KEY_PREFERENCES, onTotalCreateCount).apply();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("keyOnCreate", onCreateCount);
    }
}