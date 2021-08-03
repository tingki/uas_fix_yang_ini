package com.example.smknsu

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class proker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proker)
        val calendar = Calendar.getInstance();
        var hari = calendar.get(Calendar.DAY_OF_MONTH).toString();
        var bulan = calendar.get(Calendar.MONTH);
        var jumlah=bulan+1
        var geg = jumlah.toString();
        var tahun = calendar.get(Calendar.YEAR).toString();
        val tabsen = hari + "-0" + geg + "-" +tahun
        val tabsen2 = tahun + "-0" + geg  + "-" +hari
        val isi = findViewById<TextView>(R.id.tanggal)
        val l = LocalDate.parse(tabsen2, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        isi.setText(tabsen)
        val lihat: Button = findViewById(R.id.lihat)
        lihat.setOnClickListener {
            val pindah = Intent(this,Detail_Proker::class.java)
            startActivity(pindah)
        }
        val simpan: Button = findViewById(R.id.t_simpan)
        simpan.setOnClickListener{
            val prok = findViewById<TextView>(R.id.isi_proker).text.toString()
            val apiService = RestApiService()
            val userInfo = Data_proker(
                id_proker = "rizki0"+geg+tahun,
                username = "rizki ulirfan",
                tanggal_proker = l.toString()
            )
            val userInfo1 = Detail_dproker(
                id_proker = "rizki0"+geg+tahun,
                proker = prok
            )
            apiService.addUserDProker(userInfo1)
            {
                if (it?.proker != null) {
                    // it = newly added user parsed as response
                    // it?.id = newly added user ID
                    val pindah = Intent(this,MainActivity::class.java)
                    startActivity(pindah)
                } else {

                }
            }

            apiService.addUserProker(userInfo)
            {
                if (it?.id_proker != null) {
                    // it = newly added user parsed as response
                    // it?.id = newly added user ID
                    val pindah = Intent(this,MainActivity::class.java)
                    startActivity(pindah)
                } else {

                }
            }
        }
    }
}