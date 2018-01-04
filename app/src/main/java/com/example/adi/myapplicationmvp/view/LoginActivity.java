package com.example.adi.myapplicationmvp.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adi.myapplicationmvp.R;
import com.example.adi.myapplicationmvp.presenter.LoginPresenter;

import java.util.Collections;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,InterfaceLoginView {
    public static final String TAG=LoginActivity.class.getName();
    LoginPresenter loginPresenter;
    EditText editText1,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        button.setOnClickListener(this);
        if(loginPresenter==null){
            loginPresenter=new LoginPresenter();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onViewAttatched(this);
    }



    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onViewDettached();
    }

    LoginPresenter getPresenter()
    {
        return loginPresenter;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                getPresenter().login("username","password");
                break;
        }
    }

    @Override
    public void onLoginSuccess(String str) {
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onEmailError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onGeneralError() {

    }

    @Override
    public void clearErrors() {

    }

    @Override
    public void showProgressDialog(boolean status) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()){
            loginPresenter=null;
        }
    }
}
