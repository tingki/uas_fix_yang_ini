package com.example.smknsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun tekanAbsen(view: View) {
        val pindah = Intent(this,absen::class.java)
        startActivity(pindah)
    }

    fun tekankegiatan(view: View) {
        val pindah = Intent(this,kegiatanh::class.java)
        startActivity(pindah)
    }

    fun tekanproker(view: View) {
        val pindah = Intent(this,proker::class.java)
        startActivity(pindah)
    }

    fun tekanpengatur(view: View) {
        val pindah = Intent(this,pengaturan::class.java)
        startActivity(pindah)
    }

}