package com.example.preferenceassignment;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Sound extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.soundpreferences);
    }
}
