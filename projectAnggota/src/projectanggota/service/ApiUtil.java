/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectanggota.service;

/**
 *
 * @author PKane_NS
 */
public class ApiUtil {
    private static String BASE_URL = "http://localhost:8080/anggota/";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
    public static RetrofitInterface apiService;
    public static RetrofitInterface getApiService(){
        apiService = RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
        return apiService;
    }
}
