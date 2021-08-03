package com.example.smknsu

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUserAbsen(userData: Data_Absen, onResult: (Data_Absen?) -> Unit){
        val retrofit = ServiceBuilder.buildService(Interface::class.java)
        retrofit.addUserAbsen(userData).enqueue(
            object : Callback<Data_Absen> {
                override fun onFailure(call: Call<Data_Absen>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Data_Absen>, response: Response<Data_Absen>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

    fun addUserProker(userData: Data_proker, onResult: (Data_proker?) -> Unit){
        val retrofit = ServiceBuilder.buildService(Interface::class.java)
        retrofit.addUserProker(userData).enqueue(
            object : Callback<Data_proker> {
                override fun onFailure(call: Call<Data_proker>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Data_proker>, response: Response<Data_proker>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }



    fun addUserDProker(userData: Detail_dproker, onResult: (Detail_dproker?) -> Unit){
        val retrofit = ServiceBuilder.buildService(Interface::class.java)
        retrofit.addUserDProker(userData).enqueue(
            object : Callback<Detail_dproker> {
                override fun onFailure(call: Call<Detail_dproker>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Detail_dproker>, response: Response<Detail_dproker>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

    fun addUserKegiatan(userData: Data_kegiatan, onResult: (Data_kegiatan?) -> Unit){
        val retrofit = ServiceBuilder.buildService(Interface::class.java)
        retrofit.addUserKegiatan(userData).enqueue(
            object : Callback<Data_kegiatan> {
                override fun onFailure(call: Call<Data_kegiatan>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Data_kegiatan>, response: Response<Data_kegiatan>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }


}