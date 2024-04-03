package com.devjobs.app.views.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devjobs.app.R


class ProfessionAdapter(private val professions:List<String>):RecyclerView.Adapter<ProfessionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProfessionViewHolder(layoutInflater.inflate(R.layout.item_choose_profession, parent, false))
    }

    override fun getItemCount(): Int {
        return this.professions.size
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        holder.bind(professions[position])
    }
}