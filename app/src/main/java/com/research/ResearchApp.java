package com.research;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by mienhoang on 1/19/18.
 */

public class ResearchApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setFont();
    }

    private void setFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/roboto/Roboto-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
