package com.example.mvp.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public  class User implements  IUser {

    private String email,password;

    public User(String email,String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isvalidData() {
        //1.check Email is empty
        //2.check email is matches pattern
        //3.check email > 6
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 6 ;
    }
}
