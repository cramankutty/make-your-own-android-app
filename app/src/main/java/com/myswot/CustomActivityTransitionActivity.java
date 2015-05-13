package com.myswot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomActivityTransitionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }
    
    public void onClickNext1(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 500);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void onClickNext2(View view) {
        Intent intent = new Intent(this, SecondActivity1.class);
        startActivityForResult(intent, 500);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onClickNext3(View view) {
        Intent intent = new Intent(this, TwoPaneUi.class);
        startActivityForResult(intent, 500);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onClickNext4(View view) {
        Intent intent = new Intent(this, ESSSpinnerActivity.class);
        startActivityForResult(intent, 500);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onClickNext6(View view) {
        Intent intent = new Intent(this, MentorActivity.class);
        startActivityForResult(intent, 500);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}