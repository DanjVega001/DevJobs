package com.devjobs.app.ui.views.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.devjobs.app.R
import com.devjobs.app.core.constants.Constants
import com.devjobs.app.databinding.FragmentJobDetailBinding
import com.devjobs.app.ui.viewmodels.JobDetailsViewModel
import com.squareup.picasso.Picasso
import java.util.Calendar
import java.util.Locale


class JobDetailFragment : Fragment() {
    private var _binding:FragmentJobDetailBinding? = null
    private val binding get() = _binding!!
    private val args:JobDetailFragmentArgs by navArgs()
    private val jobsDetailsViewModel:JobDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearch()
        loadingData()
        fetchData()
    }

    private fun loadingData() {
        jobsDetailsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
                binding.frameLayoutJobDetails.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.frameLayoutJobDetails.visibility = View.VISIBLE
            }
        })
    }

    private fun fetchData() {
        jobsDetailsViewModel.jobsDetailsModel.observe(viewLifecycleOwner, Observer { job ->
            Log.d("job", job.toString())
            binding.txtJobTitleDetails.text = job.jobTitle
            if (job.employerLogo == null) Picasso.get().load(Constants.URL_NO_IMAGE).into(binding.imgLogoEmployerDetails)
            else Picasso.get().load(job.employerLogo).into(binding.imgLogoEmployerDetails)
            binding.txtNameEmployerDetails.text = job.employerName
            if (job.jobCity == null) binding.txtLocationDetails.text = job.jobCountry
            else binding.txtLocationDetails.text = "${job.jobCity}, ${job.jobCountry}"
            binding.txtEmployerTypeDetails.text = job.jobEmploymentType
            if (job.isRemote) binding.txtRemotePresencialDetails.text = "Remoto"
            else binding.txtRemotePresencialDetails.text = "Presencial"
            if (job.jobRequiredExperience.noExperience || job.jobRequiredExperience.experienceInMonths == null)
                binding.txtExperienceDetails.text = "Sin experiencia"
            else binding.txtExperienceDetails.text =
               "${(job.jobRequiredExperience.experienceInMonths / 12)} años de experiencia"
            binding.txtDatePublished.text = formattedDate(job.dateTime)
            binding.txtDescriptionDetails.text = job.jobDescription

            openJobLink(job.jobApplyLink)

        })
    }

    private fun openJobLink(link:String) {
        binding.btnGoToJob.setOnClickListener {
            val url:Uri = Uri.parse(link)
            startActivity(Intent(Intent.ACTION_VIEW, url))
        }
    }

    private fun formattedDate(dateTime: String): String {
        val formattedDate = dateTime.substring(0,10)
        val dateSplit = formattedDate.split("-")
        return "Fecha de publicación: ${dateSplit[2]} de ${obtenerNombreMes(dateSplit[1].toInt())} del ${dateSplit[0]}"
    }

    private fun obtenerNombreMes(numeroMes: Int): String? {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, numeroMes - 1)
        return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
    }

    private fun initSearch() {
        jobsDetailsViewModel.searchJobDetails(args.jobID)
    }


}