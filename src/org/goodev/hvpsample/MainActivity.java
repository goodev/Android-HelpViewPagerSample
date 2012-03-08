package org.goodev.hvpsample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    private static final String LAUNCHED_KEY = "first_use";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final SharedPreferences pref = getSharedPreferences("test", Context.MODE_PRIVATE);
        final boolean isFirstLuanched = pref.getBoolean(LAUNCHED_KEY, true);
        if(isFirstLuanched) {
            pref.edit().putBoolean(LAUNCHED_KEY, false).commit();
            Intent intent = new Intent(getApplicationContext(), SampleActivity.class);
            startActivity(intent);
        }
        findViewById(R.id.button).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                pref.edit().putBoolean(LAUNCHED_KEY, true).commit();
            }
        });
    }
}
