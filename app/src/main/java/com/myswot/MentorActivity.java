package com.myswot;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MentorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor);

    }

     public void onClickSms(View view) {
        Intent intent = new Intent(this, SendSMSActivity.class);
        startActivityForResult(intent, 600);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    public void onClickEmail(View view) {
        Intent intent = new Intent(this, SendEmailActivity.class);
        startActivityForResult(intent, 600);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }
    public void onClickweb(View view) {
        Intent browserIntent =
                new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ramconsultancy.in"));
        startActivity(browserIntent);
          }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      //  overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }


}
