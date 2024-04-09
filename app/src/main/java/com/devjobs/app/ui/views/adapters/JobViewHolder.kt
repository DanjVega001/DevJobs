package com.devjobs.app.ui.views.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.devjobs.app.R
import com.devjobs.app.core.constants.Constants
import com.devjobs.app.data.models.Job
import com.devjobs.app.ui.views.fragments.JobsFragmentDirections
import com.squareup.picasso.Picasso

class JobViewHolder(private val view:View): ViewHolder(view){

    private val imgLogoEmployer:ImageView = view.findViewById(R.id.imgLogoEmployer)
    private val txtJobTitle:TextView = view.findViewById(R.id.txtJobTitle)
    private val txtNameEmployer:TextView = view.findViewById(R.id.txtNameEmployer)
    private val txtCityName:TextView = view.findViewById(R.id.txtCityName)
    private val txtCountryName:TextView = view.findViewById(R.id.txtCountryName)
    private val txtSeparator:TextView = view.findViewById(R.id.txtSeparador)
    private val constraintSingleJob:ConstraintLayout = view.findViewById(R.id.constraintSingleJob)


    fun bind(job: Job, linearLayout: LinearLayout) {
        if (job.jobCity == null) txtSeparator.visibility = View.GONE
        if (job.employerLogo == null) Picasso.get().load(Constants.URL_NO_IMAGE).into(imgLogoEmployer)
        else Picasso.get().load(job.employerLogo).into(imgLogoEmployer)
        txtJobTitle.text = job.jobTitle
        txtNameEmployer.text = job.employerName
        txtCityName.text = job.jobCity
        txtCountryName.text = job.jobCountry


        constraintSingleJob.setOnClickListener {
            linearLayout.visibility = View.GONE
            view.findNavController().navigate(JobsFragmentDirections.actionJobsFragmentToJobDetailFragment(
                jobID = job.id
            ))
        }
    }
}