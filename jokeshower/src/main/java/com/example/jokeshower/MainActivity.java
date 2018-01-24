package com.example.jokeshower;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by xayru on 1/13/2018.
 */

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_activity_main);
        String joke = getIntent().getStringExtra("joke");
        TextView textView = findViewById(R.id.joke_text);
        textView.setText(joke);
    }
}
