package com.example.adi.myapplicationmvp.view;

/**
 * Created by Adi on 12/12/2017.
 */

public interface InterfaceLoginView {
     void onLoginSuccess(String str);
     void onEmailError();
     void onPasswordError();
     void onGeneralError();
     void clearErrors();
     void showProgressDialog(boolean status);
}
