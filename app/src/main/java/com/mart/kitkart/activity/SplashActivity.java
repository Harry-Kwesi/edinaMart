package com.mart.kitkart.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.mart.kitkart.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000;
    private ActivitySplashBinding binding;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean isStarted = false;
    private long startTime = System.currentTimeMillis();
    private final long DEFAULT_SPLASHPAGE_INTERVAL = 2500;
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Install SplashScreen API
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate");

        // Optionally display version information
        // binding.versionView.setText(Tools.getDisplayAppVersion());

        handler.postDelayed(() -> {
            if (!isStarted) {
                isStarted = true;
                handler.post(startRunnable);
            }
        }, SPLASH_DELAY);
    }

    private final Runnable startRunnable = new Runnable() {
        public void run() {
            Log.d(TAG, "startRunnable executed");
            // Perform API requests or other tasks here
            // Mocking API call delay with handler.postDelayed for demonstration
            handler.postDelayed(appSettingsRunnable, 500);
        }
    };

    private final Runnable appSettingsRunnable = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "appSettingsRunnable executed");
            proceedNextActivity();
        }
    };

    private void proceedNextActivity() {
        if (handler == null) return;

        try {
            runOnUiThread(() -> {
                long diffTime = System.currentTimeMillis() - startTime;
                Log.d(TAG, "Time to load data: " + diffTime + " ms");
                if (diffTime < DEFAULT_SPLASHPAGE_INTERVAL) {
                    try {
                        Thread.sleep(DEFAULT_SPLASHPAGE_INTERVAL - diffTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(
                        SplashActivity.this, android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(intent, options.toBundle());
                finish();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
