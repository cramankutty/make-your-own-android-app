package com.myswot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity  extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);





}
    public void onClickNext(View view) {
        Intent intent = new Intent(this, CustomActivityTransitionActivity.class);
        startActivityForResult(intent, 500);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
