package com.myswot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, CustomActivityTransitionActivity.class);
        startActivityForResult(intent, 600);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      //  overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }
}
