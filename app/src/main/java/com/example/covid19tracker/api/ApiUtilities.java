package com.example.covid19tracker.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

public static Retrofit retrofit = null;
//    private static Retrofit retrofit2=null;

//    public static final String BASE_URL = "https://wmserviceproviderapp-dot-wedmist-app1.appspot.com/";
//    //https://wmserviceproviderapp-dot-wedmist-app1.appspot.com/


    public static ApiInterface getAPiInterface(){

        if (retrofit == null){

//            Gson gson = new GsonBuilder().setLenient().create();
//
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiInterface.BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();

//            retrofit = new Retrofit.Builder()
//                    .baseUrl(ApiInterface.BASE_URL2)
//                    .addConverterFactory( GsonConverterFactory.create(gson))
//                    .build();

        }









        return retrofit.create(ApiInterface.class);
    }


}
