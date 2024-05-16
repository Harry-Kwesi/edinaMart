package com.mart.kitkart.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

public class CustomFontButton extends AppCompatButton {

    public CustomFontButton(Context context) {
        super(context);
        init(context);
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "PlusJakartaSans-SemiBold.ttf");
        setTypeface(typeface);
    }
}

