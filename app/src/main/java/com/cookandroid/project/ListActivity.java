package com.cookandroid.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        findViewById(R.id.backButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.backButton:
                    startMainActivity();
                    break;
            }
        }
    };

    private void startMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void onButton0Clicked(View view)
    {
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://gachon.webex.com/meet/cbkim"));
        startActivity(intent);
    }

    public void onButton1Clicked(View view)
    {
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://gachon.webex.com/meet/seokhee5"));
        startActivity(intent);
    }

    public void onButton2Clicked(View view)
    {
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://gachon.webex.com/meet/jwchoi"));
        startActivity(intent);
    }
}