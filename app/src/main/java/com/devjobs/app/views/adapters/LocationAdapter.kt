package com.devjobs.app.views.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devjobs.app.R

class LocationAdapter(private val locations:List<String>) : RecyclerView.Adapter<LocationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LocationViewHolder(layoutInflater.inflate(R.layout.item_choose_location, parent, false))
    }

    override fun getItemCount(): Int {
        return this.locations.size
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location:String = locations[position];
        holder.bind(location)
    }
}