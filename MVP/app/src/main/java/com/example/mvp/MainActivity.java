package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.Presenter.ILoginPresenter;
import com.example.mvp.Presenter.LoginPresenter;
import com.example.mvp.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText entText,entPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
            btnLogin = (Button)findViewById(R.id.btnLogin);
            entText = (EditText)findViewById(R.id.entEmail);
            entPassword = (EditText)findViewById(R.id.entPassword);

        //init
            loginPresenter = new LoginPresenter(this);

        //event
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginPresenter.onLogin(entText.getText().toString(),entPassword.getText().toString());
                    openProfile();
                }
            });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    public void openProfile(){
        Intent intent = new Intent(this,ProfileActivity.class);
        intent.putExtra("username", entText.getText().toString());
        intent.putExtra("password",entPassword.getText().toString());

        startActivity(intent);
    }
}