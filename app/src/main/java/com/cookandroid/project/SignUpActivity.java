package com.cookandroid.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signUpButton).setOnClickListener(onClickListener);
        findViewById(R.id.gotoLoginButton).setOnClickListener(onClickListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.signUpButton:
                    signUp();
                    break;
                case R.id.gotoLoginButton:
                    startLoginActivity();
                    break;
            }
        }
    };

    private void signUp() {
        String email = ((EditText)findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();

        if(email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {

            if(password.equals(passwordCheck)){
                mAuth.signInAnonymously()
                        .addOnCompleteListener(this, (task) -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("??????????????? ??????????????? ???????????????.");
                            } else {
                                if(task.getException() != null){
                                    startToast(task.getException().toString());
                                }
                            }
                        });
            }else{
                startToast("??????????????? ???????????? ????????????.");
            }
        }else{
            startToast("????????? ?????? ??????????????? ??????????????????.");
        }
    }

    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}