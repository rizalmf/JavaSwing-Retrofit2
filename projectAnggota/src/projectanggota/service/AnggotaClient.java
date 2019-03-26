/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectanggota.service;

import java.util.List;
import projectanggota.model.Anggota;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;
/**
 *
 * @author PKane_NS
 * ini class untuk consume API tadi
 * contoh : http://localhost:8080/anggota/save?nama=
 * ada kata anggota disana berarti API td sudah dibuild dan dideploy ke tomcat folder webapps dengan nama anggota 
 * kalau belum di build trus lngsung di run dari IDE cukup http://localhost:8080/save?nama= saja :D
 */
public class AnggotaClient {
    private RetrofitInterface api;
    public List<Anggota> getAnggotas(){
        try {
            api = ApiUtil.getServiceClass();
            Call<List<Anggota>> call = api.getList();
            return call.execute().body();
        } catch (Exception e) {
            Logger.getLogger(AnggotaClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return new ArrayList<>();
    }
    public List<Anggota> getAnggotasByKepo(String kepo){
        try {
            api = ApiUtil.getServiceClass();
            Call<List<Anggota>> call = api.getListByKepo(kepo);
            return call.execute().body();
        } catch (Exception e) {
            Logger.getLogger(AnggotaClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return new ArrayList<>();
    }
    public String saveAnggota(String nama, String nim){
        String returnString= "Gk ada koneksi :D";
        try {
            api = ApiUtil.getServiceClass();
            Call<Map<String, Object>> call = api.save(nama, nim);
            Map<String, Object> map = call.execute().body();
            String status = (String) map.get("status");
            if (status.equals("sukses")) {
                returnString = (String) map.get("msg");
            }
        } catch (Exception e) {
            Logger.getLogger(AnggotaClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnString;
    }
    public String deleteAnggota(long id){
        String returnString= "Gk ada koneksi :D";
        try {
            api = ApiUtil.getServiceClass();
            Call<Map<String, Object>> call = api.delete(String.valueOf(id));
            Map<String, Object> map = call.execute().body();
            returnString = (String) map.get("msg");
        } catch (Exception e) {
            Logger.getLogger(AnggotaClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return returnString;
    }
}
