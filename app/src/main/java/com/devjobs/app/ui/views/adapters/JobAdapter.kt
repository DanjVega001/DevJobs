package com.devjobs.app.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.devjobs.app.R
import com.devjobs.app.data.models.Job

class JobAdapter(private val listJobs:List<Job>, private val linearLayout: LinearLayout) : RecyclerView.Adapter<JobViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JobViewHolder(layoutInflater.inflate(R.layout.item_job, parent, false))
    }

    override fun getItemCount(): Int {
        return listJobs.size
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.bind(listJobs[position],linearLayout)
    }
}