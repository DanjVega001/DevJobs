package com.devjobs.app.ui.views.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.devjobs.app.R
import com.devjobs.app.core.util.ManageSharedPreferences
import com.devjobs.app.databinding.FragmentSalaryJobBinding
import com.devjobs.app.ui.viewmodels.SalaryViewModel


class SalaryJobFragment : Fragment() {

    private var _binding:FragmentSalaryJobBinding?=null
    private val binding get() = _binding!!
    private val salaryViewModel:SalaryViewModel by viewModels()
    private var locationSelected = ""
    private var professionSelected = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSalaryJobBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initValues()
        loadingData()
        doRequest()
        fetchData()
    }

    private fun fetchData() {
        salaryViewModel.salaryModel.observe(viewLifecycleOwner, Observer {
            binding.txtPage.text = "Datos según la página ${it.publisherName}"
            binding.txtMedianSalary.text = "$"+it.medianSalary.toInt().toString()
            binding.txtMinSalary.text = "$"+it.minSalary.toInt().toString()
            binding.txtMaxSalary.text = "$"+it.maxSalary.toInt().toString()
            binding.txtSalaryPeriod.text = it.salaryPeriod
            binding.txtSalaryCurrency.text = it.salaryCurrency
            openJobLink(it.publisherLink)
        })
    }

    private fun openJobLink(link:String) {
        binding.btnMoreInfo.setOnClickListener {
            val url: Uri = Uri.parse(link)
            startActivity(Intent(Intent.ACTION_VIEW, url))
        }
    }

    private fun doRequest() {
        if (locationSelected!="" && professionSelected!=""){
            salaryViewModel.estimatedSalary(professionSelected, locationSelected)
        }
    }

    private fun initValues() {
        locationSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_location_selected), requireContext())
        professionSelected = ManageSharedPreferences.getPreferences(getString(R.string.key_profession_selected), requireContext())
    }

    private fun loadingData() {
        salaryViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progressBarSalary.visibility = View.VISIBLE
                binding.frameLayoutSalary.visibility = View.GONE
            } else {
                binding.progressBarSalary.visibility = View.GONE
                binding.frameLayoutSalary.visibility = View.VISIBLE
            }
        })
    }


}