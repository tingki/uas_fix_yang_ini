package com.example.smknsu

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class kegiatanh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kegiatanh)
        val calendar = Calendar.getInstance();
        var hari = calendar.get(Calendar.DAY_OF_MONTH).toString();
        var bulan = calendar.get(Calendar.MONTH);
        var jumlah = bulan + 1
        var geg = jumlah.toString();
        var tahun = calendar.get(Calendar.YEAR).toString();
        var tabsen = hari + "/" + geg + "/" + tahun
        val tabsen2 = tahun + "-0" + geg + "-" + hari
        var isi = findViewById<TextView>(R.id.tanggal);
        isi.setText(tabsen);
        val l = LocalDate.parse(tabsen2, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val simpan: Button = findViewById(R.id.t_simpan)
        simpan.setOnClickListener {
            val apiService = RestApiService()
            val userInfo = Data_kegiatan(
                id_proker = "rizki0" + geg + tahun,
                username = "rizki ulirfan",
                tanggal_dilaporkan = l.toString()
            )
            apiService.addUserKegiatan(userInfo)
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