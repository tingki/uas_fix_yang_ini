package com.example.smknsu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Detail_Proker : AppCompatActivity() {
    lateinit var rv_data : RecyclerView
    var ambilData: ArrayList<Detail_dproker> = arrayListOf()
    val retrofit = ServiceBuilder.buildService(Interface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_proker)
        rv_data = findViewById(R.id.rv_data)
        retrofit.getUserProker().enqueue(
            object : Callback<List<Detail_dproker>> {
                override fun onResponse(
                    call: Call<List<Detail_dproker>>,
                    response: Response<List<Detail_dproker>>
                ) {
                    if (response.isSuccessful){
                        val res = response.body()
                        ambilData.addAll(res!!)
                        rv_data.layoutManager = LinearLayoutManager(this@Detail_Proker)
                        rv_data.adapter = AdapterProker(ambilData)
                    }
                }
                override fun onFailure(call: Call<List<Detail_dproker>>, t: Throwable) {
                }
            })

               }


    }