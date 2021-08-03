package com.example.smknsu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterProker(private val listku: ArrayList<Detail_dproker>): RecyclerView.Adapter<AdapterProker.KontakViewHolder>() {

    inner class KontakViewHolder(viewku: View) : RecyclerView.ViewHolder(viewku) {
        var tvId: TextView = viewku.findViewById(R.id.tv_id)
        var tvTanaman: TextView = viewku.findViewById(R.id.tv_tanaman)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakViewHolder {
        val viewView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cv_proker, parent, false)
        return KontakViewHolder(viewView)
    }

    override fun onBindViewHolder(holder: KontakViewHolder, position: Int) {
        val dataku = listku[0]
        holder.tvId.text = dataku.id_proker
        holder.tvTanaman.text = dataku.proker
        val bundle = Bundle()
        bundle.putString("id", dataku.id_proker)
        bundle.putString("Tanaman", dataku.proker)

    }

    override fun getItemCount(): Int {
        return 1
    }

}