package com.example.covid19tracker.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    static final  String BASE_URL="https://corona.lmao.ninja/v2/";
//    static final  String BASE_URL2=" https://api.rootnet.in/covid19-in/stats/latest";


    @GET("countries")
    Call<List<CountryData>> getCountryData();


//   @GET("stats/latest")
//    Call<List<statedata>> getstateData();

}
