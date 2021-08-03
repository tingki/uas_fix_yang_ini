package com.example.smknsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.icu.util.Calendar
import android.widget.Button
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class absen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen)
        val calendar = Calendar.getInstance()
        val hari = calendar.get(Calendar.DAY_OF_MONTH).toString()
        val bulan = calendar.get(Calendar.MONTH)
        val jumlah=bulan+1
        val geg = jumlah.toString()
        val tahun = calendar.get(Calendar.YEAR).toString()
        val tabsen = hari + "-0" + geg + "-" +tahun
        val tabsen2 = tahun + "-0" + geg  + "-" +hari
        val isi = findViewById<TextView>(R.id.tanggal)
        val l = LocalDate.parse(tabsen2, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        isi.setText(tabsen)
        val hadir: Button = findViewById(R.id.b_hadir)
        hadir.setOnClickListener{
            val apiService = RestApiService()
            val userInfo = Data_Absen(
                username = "rizki ulirfan",
                tanggal_absen = l.toString(),
                status = "hadir"
                 )
            apiService.addUserAbsen(userInfo)
            {
                    if (it?.username != null) {
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