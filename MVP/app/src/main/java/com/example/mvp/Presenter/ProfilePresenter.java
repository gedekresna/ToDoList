package com.example.mvp.Presenter;

import com.example.mvp.Model.IProfile;
import com.example.mvp.Model.Profile;
import com.example.mvp.View.IProfileView;

public class ProfilePresenter implements IProfilePresenter {


    IProfileView profileView;
    String email;
    String password;

    public ProfilePresenter(IProfileView profileView, String email, String password) {
        this.profileView = profileView;
        this.email = email;
        this.password = password;
    }

    @Override
    public void onViewCreated() {
        this.profileView.onProfileResult(this.email, this.password);
    }
}
