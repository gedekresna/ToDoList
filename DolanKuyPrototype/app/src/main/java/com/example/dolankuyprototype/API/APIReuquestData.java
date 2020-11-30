package com.example.dolankuyprototype.API;

import com.example.dolankuyprototype.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIReuquestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

}
