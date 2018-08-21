package com.example.hoangminhk4b.bankingwebservice;

import com.example.hoangminhk4b.bankingwebservice.Models.HistoryModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface APISource {
    final String url="http://52.74.33.207:8080/Banking/";


    @POST("doiTacLogin")
    @Headers("Content-Type: application/json")
    Call<Boolean> getLogin(@Body Map<String,String> body);

    @Headers("Content-Type: application/json")
    @POST("lichSuGiaoDich")
    Call<List<HistoryModel>> getHistory(@Body Map<String,Object> body);

    @Headers("Content-Type: application/json")
    @POST("giaoDich")
    Call<Boolean> setGiaoDich(@Body Map<String,Object> body);

    @Headers("Content-Type: application/json")
    @POST("checkSoDuKH/{soTien}")
    Call<Boolean> checkSoDuKH(@Path("soTien") String st, @Body Map<String,String> mkh);
 }
