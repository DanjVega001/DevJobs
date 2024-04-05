package com.devjobs.app.ui.views.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devjobs.app.R
import com.devjobs.app.core.constants.Constants
import com.devjobs.app.data.models.Job
import com.squareup.picasso.Picasso

class JobViewHolder(private val view:View): ViewHolder(view){

    private val imgLogoEmployer:ImageView = view.findViewById(R.id.imgLogoEmployer)
    private val txtJobTitle:TextView = view.findViewById(R.id.txtJobTitle)
    private val txtNameEmployer:TextView = view.findViewById(R.id.txtNameEmployer)
    private val txtCityName:TextView = view.findViewById(R.id.txtCityName)
    private val txtCountryName:TextView = view.findViewById(R.id.txtCountryName)
    private val txtSeparator:TextView = view.findViewById(R.id.txtSeparador)


    fun bind(job: Job) {
        if (job.jobCity == null) txtSeparator.visibility = View.GONE
        if (job.employerLogo == null) Picasso.get().load(Constants.URL_NO_IMAGE).into(imgLogoEmployer)
        else Picasso.get().load(job.employerLogo).into(imgLogoEmployer)
        txtJobTitle.text = job.jobTitle
        txtNameEmployer.text = job.employerName
        txtCityName.text = job.jobCity
        txtCountryName.text = job.jobCountry
    }
}