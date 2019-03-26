/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectanggota.service;

import java.util.List;
import java.util.Map;
import projectanggota.model.Anggota;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * @author PKane_NS
 */
public interface RetrofitInterface {
    @GET("get_list")
    Call<List<Anggota>> getList();
    
    @GET("get_list_by_kepo")
    Call<List<Anggota>> getListByKepo(@Query("kepo") String kepo);
    
    @GET("save")
    Call<Map<String, Object>> save(@Query ("nama") String nama,@Query ("nim") String nim);
    
    @GET("delete")
    Call<Map<String, Object>> delete(@Query ("id") String id);
}
