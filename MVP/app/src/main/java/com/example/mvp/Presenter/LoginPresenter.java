package com.example.mvp.Presenter;

import com.example.mvp.Model.User;
import com.example.mvp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {

            this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password){
       User user = new User(email,password);
        boolean isLoginSuccess = user.isvalidData();

        if (isLoginSuccess) {
            loginView.onLoginResult("Login Success");
        }else{
            loginView.onLoginResult("Login Failed");
        }
    }
}
