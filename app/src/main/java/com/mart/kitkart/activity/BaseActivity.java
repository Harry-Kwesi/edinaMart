package com.mart.kitkart.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.mart.kitkart.databinding.ActivityBaseBinding;


public class BaseActivity extends AppCompatActivity {

    private ActivityBaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}