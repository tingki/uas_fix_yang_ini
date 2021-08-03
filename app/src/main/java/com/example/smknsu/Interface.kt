package com.example.smknsu
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Interface {
    @POST("Absen")
    fun addUserAbsen(@Body userData: Data_Absen): Call<Data_Absen>

    @POST("Proker")
    fun addUserProker(@Body userData: Data_proker): Call<Data_proker>

    @POST("Detailproker")
    fun addUserDProker(@Body userData: Detail_dproker): Call<Detail_dproker>

    @POST("Harian")
    fun addUserKegiatan(@Body userData: Data_kegiatan): Call<Data_kegiatan>

    @GET("Detailproker")
    fun getUserProker(): Call<List<Detail_dproker>>

    @GET("Absen")
    fun getUser(): Call <List<Data_Absen>>
}