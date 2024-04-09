package com.devjobs.app.ui.views.adapters

import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.devjobs.app.R
import com.devjobs.app.core.util.ManageSharedPreferences
import com.devjobs.app.ui.views.fragments.ChooseLocationFragmentDirections

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
            view.findNavController().navigate(ChooseLocationFragmentDirections.actionChooseLocationFragment2ToHomePage())
        }
    }



}