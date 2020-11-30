package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.Presenter.ILoginPresenter;
import com.example.mvp.Presenter.LoginPresenter;
import com.example.mvp.View.ILoginView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText entText,entPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
            btnLogin = (Button)findViewById(R.id.btnLogin);
            entText = (EditText)findViewById(R.id.entEmail);
            entPassword = (EditText)findViewById(R.id.entPassword);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        //pengecekan name

        final String name = sharedPreferences.getString(KEY_NAME,null);

        if(name != null){
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        }

        // Ganti Layout SharedPreferences
       btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,entText.getText().toString());
                editor.putString(KEY_EMAIL,entPassword.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Login succesfull",Toast.LENGTH_SHORT).show();
            }
        });


//        //init
//            loginPresenter = new LoginPresenter(this);
//
//        //event
//            btnLogin.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    loginPresenter.onLogin(entText.getText().toString(),entPassword.getText().toString());
//                    openProfile();
//                }
//            });

//            //masukin data ke sharedpreferences
//        ArrayList<String> dataList = new ArrayList<>();
//
//        dataList.add("Tugas WPPL");
//        dataList.add("Workout");
//        dataList.add("Radep ngonsep PKO");
//        dataList.add("Take video PKO");
//
//        HashSet<String> setList =new HashSet<>();
//
//        setList.addAll(dataList);
//
//        SharedPreferences sharedPreferences = this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
//
//        sharedPreferences.edit().putStringSet("data", setList).apply();
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