package com.example.adi.myapplicationmvp.presenter;

import com.example.adi.myapplicationmvp.model.LoginModel;
import com.example.adi.myapplicationmvp.view.InterfaceLoginView;

/**
 * Created by Adi on 12/12/2017.
 */

public class LoginPresenter implements LoginModel.ResultCallBack {
    private InterfaceLoginView interfaceLoginView;
    private LoginModel loginModel;


    public void onViewAttatched(InterfaceLoginView interfaceLoginView_){
        interfaceLoginView=interfaceLoginView_;
        updateView();
    }
    public LoginPresenter(){
        loginModel=new LoginModel();

    }

    private void updateView() {
        if(getView()==null){
            return;
        }
        getView().showProgressDialog(true);
    }

    public void onViewDettached(){
        interfaceLoginView=null;
    }

    public InterfaceLoginView getView(){
        return interfaceLoginView;
    }

    public void login(String userName , String project){
        loginModel.login(this);

    }

    @Override
    public void onSuccess(String str) {

        getView().onLoginSuccess(str);

    }
}
