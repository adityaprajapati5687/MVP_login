package com.example.adi.myapplicationmvp.model;

/**
 * Created by Adi on 12/12/2017.
 */

public class LoginModel {


    public interface ResultCallBack{

        void onSuccess(String str);

    }

    public void login(ResultCallBack resultCallBack) {
        resultCallBack.onSuccess("hello");

    }
}
