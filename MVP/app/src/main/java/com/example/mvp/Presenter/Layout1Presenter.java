package com.example.mvp.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvp.View.ILayout1View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Layout1Presenter implements ILayout1Presenter {

   ILayout1View iLayout1View;

    public Layout1Presenter(ILayout1View iLayout1View) {
        this.iLayout1View = iLayout1View;
    }

    @Override
    public ArrayList<String> fetchData() {
        String packageName = iLayout1View.getContext().getPackageName();

        SharedPreferences sharedPreferences = iLayout1View.getContext().getSharedPreferences(packageName, Context.MODE_PRIVATE);

        Set<String> setList = sharedPreferences.getStringSet("data", null);

        ArrayList<String> dataList = new ArrayList<>();

        dataList.addAll(setList);

        return dataList;
    }
}
