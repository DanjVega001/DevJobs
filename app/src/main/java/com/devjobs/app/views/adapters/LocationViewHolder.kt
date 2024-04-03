package com.devjobs.app.views.adapters

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.devjobs.app.R

class LocationViewHolder(view:View) : RecyclerView.ViewHolder(view){

    private val btnChooseLocation:Button = view.findViewById(R.id.btnChooseLocation)
    fun bind(location:String) {
        btnChooseLocation.text = location
    }

}