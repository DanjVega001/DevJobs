package com.devjobs.app.views.adapters

import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.devjobs.app.R
import com.devjobs.app.util.ManageSharedPreferences
import com.devjobs.app.views.fragments.ChooseLocationFragmentDirections

class LocationViewHolder(private val view:View) : RecyclerView.ViewHolder(view){


    private val btnChooseLocation:Button = view.findViewById(R.id.btnChooseLocation)
    fun bind(location:String) {
        btnChooseLocation.text = location

        btnChooseLocation.setOnClickListener {
            ManageSharedPreferences.savePreferences(
                view.context.getString(R.string.key_location_selected),
                location,
                view.context
                )
            view.findNavController().navigate(ChooseLocationFragmentDirections.actionChooseLocationFragment2ToJobsFragment())
        }
    }



}