package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.Presenter.IProfilePresenter;
import com.example.mvp.Presenter.ProfilePresenter;
import com.example.mvp.View.IProfileView;

public class ProfileActivity extends AppCompatActivity implements IProfileView {

    TextView textEmail,textPassword;

    IProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);

        String intentEmail = getIntent().getExtras().getString("username");
        String intentPassword = getIntent().getExtras().getString("password");

        //init
        profilePresenter = new ProfilePresenter(this, intentEmail, intentPassword);
        profilePresenter.onViewCreated();
    }

    @Override
    public void onProfileResult(String email, String password) {
        textEmail.setText(email);
        textPassword.setText(password);
    }
}