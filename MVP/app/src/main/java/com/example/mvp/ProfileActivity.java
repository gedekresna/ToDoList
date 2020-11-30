package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.Presenter.IProfilePresenter;
import com.example.mvp.Presenter.ProfilePresenter;
import com.example.mvp.View.IProfileView;

public class ProfileActivity extends AppCompatActivity implements IProfileView {

    TextView textEmail,textPassword;
    Button btnNextLayout1;

    IProfilePresenter profilePresenter;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        //init view
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);

        btnNextLayout1 = findViewById(R.id.btnNextLayout1);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name  = sharedPreferences.getString(KEY_NAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);

        if(name != null || email != null){
            textEmail.setText("Email : "+name);
            textPassword.setText("Password : "+email);
        }else {
            Toast.makeText(ProfileActivity.this,"Failed",Toast.LENGTH_SHORT).show();
        }

//        String intentEmail = getIntent().getExtras().getString("username");
//        String intentPassword = getIntent().getExtras().getString("password");

        //init
//        profilePresenter = new ProfilePresenter(this, intentEmail, intentPassword);
//        profilePresenter.onViewCreated();

        //event
        btnNextLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLayout1();
            }
        });
    }

    @Override
    public void onProfileResult(String email, String password) {
        textEmail.setText(email);
        textPassword.setText(password);
    }

    public void openLayout1()
    {
        Intent intent = new Intent(this, Layout1Activity.class);
        startActivity(intent);
    }
}